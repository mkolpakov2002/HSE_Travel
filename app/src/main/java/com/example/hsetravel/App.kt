package com.example.hsetravel

import android.app.Application
import com.example.hsetravel.data.room.AppDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App: Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDataBase.getDatabase(this, applicationScope) }
//    val excursionRepository by lazy { CacheDataSource(database.excursionDao()) }
//    val travelRepository by lazy { CacheDataSource(database.travelDao()) }

    override fun onCreate() {
        super.onCreate()

    }

}