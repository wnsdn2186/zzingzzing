package com.example.zzingzzing.Dao

import androidx.room.*
import com.example.zzingzzing.Entity.MessageInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMessage(messageInfo: MessageInfo): Long

    @Query("SELECT * FROM tb_message_info WHERE `check` = 1")
    fun getMessage(): Flow<List<MessageInfo>>

    @Query("UPDATE tb_message_info SET contents = :contents WHERE seq = :seq")
    fun updateMessage(seq: Int, contents: String): Int

    @Delete
    fun deleteMessage(messageInfo: MessageInfo): Int
}