package com.example.zzingzzing.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "tb_message_info")
data class MessageInfo(
    @PrimaryKey(autoGenerate = true)
    val seq: Int,
    @ColumnInfo
    val contents: String,
    @ColumnInfo
    val check: Int, // 1 : Check, 0 : Uncheck
    @ColumnInfo
    val upttime: String,
    @ColumnInfo
    val regtime: String,
    @ColumnInfo
    val state: Int // 1 : Using, 0 : Unusing
)