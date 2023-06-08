package com.azwar.belajarlanjutan.repository

import com.azwar.belajarlanjutan.model.Product
import com.azwar.belajarlanjutan.model.ResponseProduct
import com.azwar.belajarlanjutan.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getProducts(): Response<ResponseProduct> {
        return withContext(Dispatchers.IO) {
                apiService.getProducts()
        }
    }

    suspend fun getProduct(id: Int): Product {
        return withContext(Dispatchers.IO){
            apiService.getProduct(id)
        }
    }


}