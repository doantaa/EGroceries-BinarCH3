package com.catnip.egroceries.data.datasource.local.preference

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.appDataStore by preferencesDataStore(
    //Todo: change it into your app name
    name = "EGroceries"
)