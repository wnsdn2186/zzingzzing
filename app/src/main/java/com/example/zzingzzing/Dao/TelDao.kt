package com.example.zzingzzing.Dao

import androidx.room.*
import com.example.zzingzzing.Entity.TelInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface TelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTel(telInfo: TelInfo): Long

    @Query("SELECT * FROM tb_tel_info WHERE `check` = 1")
    fun getTel(): Flow<List<TelInfo>>

    @Query("UPDATE tb_tel_info SET tel = :tel WHERE seq = :seq")
    fun updateTel(seq: Int, tel: String): Int

    @Delete
    fun deleteTel(telInfo: TelInfo): Int
}