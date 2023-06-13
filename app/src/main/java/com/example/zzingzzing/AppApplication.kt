package com.example.zzingzzing

import android.app.Application
import com.example.zzingzzing.Database.AppRoomDatabase
import com.example.zzingzzing.Repository.AppRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {AppRoomDatabase.getDatabase(this, applicationScope)}
//    val repository by lazy { AppRepository(database.messageDao(), database.telDao()) }
    val repository by lazy { AppRepository(database.messageDao(), database.telDao()) }
}