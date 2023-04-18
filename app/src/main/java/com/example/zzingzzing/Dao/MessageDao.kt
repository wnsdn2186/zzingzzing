package com.example.zzingzzing.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.zzingzzing.Entity.MessageInfo

@Dao
interface MessageDao {
    @Insert
    fun insertMessage(messageInfo: MessageInfo)

    @Query("SELECT contents FROM MessageInfo WHERE check = '1'")
    fun getMessage(): List<MessageInfo>
}