package com.azwar.belajarlanjutan.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.azwar.belajarlanjutan.network.ApiClient
import com.azwar.belajarlanjutan.network.ApiService
import com.azwar.belajarlanjutan.repository.ProductRepository
import com.azwar.belajarlanjutan.viewmodel.DetailProductViewModel
import com.azwar.belajarlanjutan.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerApiClient(): ApiClient {
        return ApiClient
    }

    @Singleton
    @Provides
    fun providerMainViewModel(productRepository: ProductRepository): MainViewModel {
        return MainViewModel(productRepository)
    }

    @Singleton
    @Provides
    fun providerDetailProductViewModel(repository: ProductRepository): DetailProductViewModel {
        return DetailProductViewModel(repository)
    }

    @Singleton
    @Provides
    fun providerApiService(): ApiService {
        return ApiClient.apiService
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(@ApplicationContext context: Context): ViewModelProvider.Factory {
        return ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
    }

}