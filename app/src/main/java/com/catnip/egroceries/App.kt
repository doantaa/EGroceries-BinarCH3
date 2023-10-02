package com.catnip.egroceries

import android.app.Application
import com.catnip.egroceries.data.local.database.AppDatabase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(this)
    }
}