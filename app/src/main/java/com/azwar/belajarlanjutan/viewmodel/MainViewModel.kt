package com.azwar.belajarlanjutan.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azwar.belajarlanjutan.model.Product
import com.azwar.belajarlanjutan.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    fun fatchProducts() {
        viewModelScope.launch {
            _products.value = productRepository.getProducts().body()?.products
            Log.e("MainViewModel", "Di fatchProduct")
        }
    }

}