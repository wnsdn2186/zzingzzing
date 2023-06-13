package com.example.zzingzzing.Repository

import androidx.annotation.WorkerThread
import com.example.zzingzzing.Dao.MessageDao
import com.example.zzingzzing.Dao.TelDao
import com.example.zzingzzing.Entity.MessageInfo
import com.example.zzingzzing.Entity.TelInfo
import kotlinx.coroutines.flow.Flow

class AppRepository(private val messageDao: MessageDao, private val telDao: TelDao) {
    val allMessage: Flow<List<MessageInfo>> = messageDao.getMessage()
    val allTel: Flow<List<TelInfo>> = telDao.getTel()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertMessage(messageInfo: MessageInfo) {
        messageDao.insertMessage(messageInfo)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertTel(telInfo: TelInfo) {
        telDao.insertTel(telInfo)
    }
}