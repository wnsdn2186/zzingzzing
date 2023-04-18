package com.example.zzingzzing.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class MessageInfo(
    @PrimaryKey val seq: Int,
    @ColumnInfo val contents: String,
    @ColumnInfo val check: Int,
    @ColumnInfo val upttime: Timestamp,
    @ColumnInfo val regtime: Timestamp,
    @ColumnInfo val state: Int
)