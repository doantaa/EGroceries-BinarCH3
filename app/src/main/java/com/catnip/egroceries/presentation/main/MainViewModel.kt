package com.catnip.egroceries.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSource
import kotlinx.coroutines.Dispatchers

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class MainViewModel(
    private val userPreferenceDataSource: UserPreferenceDataSource
) : ViewModel() {

    // use as variable
    val userDarkModeLiveData = userPreferenceDataSource
        .getUserDarkModePreferenceFlow().asLiveData(Dispatchers.IO)

    val userLanguageLiveData = userPreferenceDataSource
        .getUserLanguagePreferenceFlow().asLiveData(Dispatchers.IO)
    // use as function
//    fun getUserDarkModeLiveData() = userPreferenceDataSource
//        .getUserDarkModePreferenceFlow().asLiveData(Dispatchers.IO)
}