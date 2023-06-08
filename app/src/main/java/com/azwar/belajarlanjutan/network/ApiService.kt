package com.azwar.belajarlanjutan.network

import com.azwar.belajarlanjutan.model.Product
import com.azwar.belajarlanjutan.model.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProducts(): Response<ResponseProduct>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product

}