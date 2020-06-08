package hr.ferit.josip.rmalv4_2.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hr.ferit.josip.rmalv4_2.data.api.ApiHelper
import hr.ferit.josip.rmalv4_2.data.repository.MainRepository
import hr.ferit.josip.rmalv4_2.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
