package com.example.zzingzzing.Database

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.zzingzzing.Dao.MessageDao
import com.example.zzingzzing.Dao.TelDao
import com.example.zzingzzing.Entity.MessageInfo
import com.example.zzingzzing.Entity.TelInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@Database(
    entities = [MessageInfo::class, TelInfo::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao
    abstract fun telDao(): TelDao

    private class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var messageDao = database.messageDao()
                    var telDao = database.telDao()

                    var message1 = MessageInfo(0, "테스트1", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var message2 = MessageInfo(1, "테스트2", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var message3 = MessageInfo(2, "테스트3", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var message4 = MessageInfo(3, "테스트4", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var message5 = MessageInfo(4, "테스트5", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)

                    messageDao.insertMessage(message1)
                    messageDao.insertMessage(message2)
                    messageDao.insertMessage(message3)
                    messageDao.insertMessage(message4)
                    messageDao.insertMessage(message5)


                    var tel1 = TelInfo(0, "테스트1", "010-1111-1111", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var tel2 = TelInfo(0, "테스트2", "010-2222-2222", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var tel3 = TelInfo(0, "테스트3", "010-3333-3333", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var tel4 = TelInfo(0, "테스트4", "010-4444-4444", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)
                    var tel5 = TelInfo(0, "테스트5", "010-5555-5555", 0, LocalDateTime.now().toString(), LocalDateTime.now().toString(), 1)

                    telDao.insertTel(tel1)
                    telDao.insertTel(tel2)
                    telDao.insertTel(tel3)
                    telDao.insertTel(tel4)
                    telDao.insertTel(tel5)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope
        ): AppRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "app_database"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}