package com.catnip.egroceries.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SettingsViewModel(
    private val userPreferenceDataSource: UserPreferenceDataSource,
) : ViewModel() {
    fun setUserDarkMode(isUsingDarkMode: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            userPreferenceDataSource.setUserDarkModePref(isUsingDarkMode)
        }
    }

    fun setUserLanguage(language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userPreferenceDataSource.setUserLanguagePref(language)
        }
    }
}