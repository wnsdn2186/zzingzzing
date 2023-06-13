package com.example.zzingzzing.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "tb_tel_info")
data class TelInfo(
    @PrimaryKey(autoGenerate = true)
    val seq: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val tel: String,
    @ColumnInfo
    val check: Int,
    @ColumnInfo
    val upttime: String,
    @ColumnInfo
    val regtime: String,
    @ColumnInfo
    val state: Int
)