package com.azwar.belajarlanjutan.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.azwar.belajarlanjutan.network.ApiService
import com.azwar.belajarlanjutan.repository.ProductRepository

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory {

//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            val repository = ProductRepository()
//            return MainViewModel(repository, application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.simpleName}")
//    }

}