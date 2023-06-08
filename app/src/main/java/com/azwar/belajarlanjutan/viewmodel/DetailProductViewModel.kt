package com.azwar.belajarlanjutan.viewmodel

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
class DetailProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    fun fatchProduct(id: Int){
        viewModelScope.launch {
            _product.value = repository.getProduct(id)
        }
    }

}