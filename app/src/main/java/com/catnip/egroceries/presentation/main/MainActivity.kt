package com.catnip.egroceries.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.catnip.egroceries.R
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSource
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSourceImpl
import com.catnip.egroceries.data.datasource.local.preference.appDataStore
import com.catnip.egroceries.databinding.ActivityMainBinding
import com.catnip.egroceries.presentation.settings.SettingsViewModel
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import com.catnip.egroceries.utils.PreferenceDataStoreHelperImpl

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels {
        val dataStore = this.appDataStore
        val dataStoreHelper: PreferenceDataStoreHelper = PreferenceDataStoreHelperImpl(dataStore)
        val dataSource: UserPreferenceDataSource = UserPreferenceDataSourceImpl(dataStoreHelper)
        GenericViewModelFactory.create(MainViewModel(dataSource))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNav()
        observeUserDarkMode()
    }

    private fun observeUserDarkMode(){
        viewModel.userDarkModeLiveData.observe(this) {isUsingDarkMode ->
            AppCompatDelegate.setDefaultNightMode(
                if(isUsingDarkMode)
                    AppCompatDelegate.MODE_NIGHT_YES
                else
                    AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.navView.setupWithNavController(navController)
    }

}