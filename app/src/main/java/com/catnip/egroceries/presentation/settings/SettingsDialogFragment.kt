package com.catnip.egroceries.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSource
import com.catnip.egroceries.data.datasource.local.preference.UserPreferenceDataSourceImpl
import com.catnip.egroceries.data.datasource.local.preference.appDataStore
import com.catnip.egroceries.databinding.FragmentSettingsDialogBinding
import com.catnip.egroceries.presentation.main.MainViewModel
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import com.catnip.egroceries.utils.PreferenceDataStoreHelperImpl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SettingsDialogFragment : BottomSheetDialogFragment() {


    private lateinit var binding: FragmentSettingsDialogBinding


    private val viewModel: SettingsViewModel by viewModels {
        val dataStore = this.requireContext().appDataStore
        val dataStoreHelper: PreferenceDataStoreHelper = PreferenceDataStoreHelperImpl(dataStore)
        val dataSource: UserPreferenceDataSource = UserPreferenceDataSourceImpl(dataStoreHelper)
        GenericViewModelFactory.create(SettingsViewModel(dataSource))
    }

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSwitchAction()
        observeUserDarkMode()
        observeUserLanguage()
    }

    private fun observeUserLanguage() {
        mainViewModel.userLanguageLiveData.observe(viewLifecycleOwner){
            if (it == "id"){
                binding.rbLangId.isChecked = true

            } else {
                binding.rbLangEn.isChecked = true

            }
        }
    }

    private fun observeUserDarkMode() {
        mainViewModel.userDarkModeLiveData.observe(viewLifecycleOwner) { isUsingDarkMode ->
            binding.swDarkMode.isChecked = isUsingDarkMode
        }
    }


    private fun setSwitchAction() {
        binding.swDarkMode.setOnCheckedChangeListener { _, isUsingDarkMode ->
            viewModel.setUserDarkMode(isUsingDarkMode)
        }

        binding.rbLangId.setOnClickListener{
            viewModel.setUserLanguage("id")
            Toast.makeText(requireContext(), "Berhasil mengubah bahasa", Toast.LENGTH_SHORT).show()
        }

        binding.rbLangEn.setOnClickListener{
            viewModel.setUserLanguage("en")
            Toast.makeText(requireContext(), "Successfully changed the language", Toast.LENGTH_SHORT).show()
        }
    }
}