package com.catnip.egroceries.data.datasource.local.preference

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow
import org.intellij.lang.annotations.Language

interface UserPreferenceDataSource {
    fun getUserDarkModePreferenceFlow() : Flow<Boolean>
    suspend fun setUserDarkModePref(isUsingDarkModePref: Boolean)
    suspend fun getUserDarkModePref() : Boolean

    fun getUserLanguagePreferenceFlow() : Flow<String>
    suspend fun setUserLanguagePref(language: String)
    suspend fun getUserLanguagePref() : String
}

class UserPreferenceDataSourceImpl(
    private val dataStoreHelper: PreferenceDataStoreHelper
): UserPreferenceDataSource {
    override fun getUserDarkModePreferenceFlow(): Flow<Boolean> {
        return dataStoreHelper.getPreference(PREF_USER_DARK_MODE, false)
    }

    override suspend fun setUserDarkModePref(isUsingDarkModePref: Boolean) {
        dataStoreHelper.putPreference(PREF_USER_DARK_MODE, isUsingDarkModePref)
    }

    override suspend fun getUserDarkModePref(): Boolean {
        return dataStoreHelper.getFirstPreference(PREF_USER_DARK_MODE, false)
    }

    override fun getUserLanguagePreferenceFlow(): Flow<String> {
        return dataStoreHelper.getPreference(PREF_USER_LANGUAGE, "id")
    }

    override suspend fun setUserLanguagePref(language: String) {
        return dataStoreHelper.putPreference(PREF_USER_LANGUAGE, language)
    }

    override suspend fun getUserLanguagePref(): String {
        return dataStoreHelper.getFirstPreference(PREF_USER_LANGUAGE, "id")
    }


    companion object {
        val PREF_USER_DARK_MODE = booleanPreferencesKey("PREF_USER_DARK_MODE")
        val PREF_USER_LANGUAGE  = stringPreferencesKey("PREF_USER_LANGUAGE")
    }
}