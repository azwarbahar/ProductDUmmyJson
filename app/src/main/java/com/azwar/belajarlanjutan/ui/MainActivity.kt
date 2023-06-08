package com.azwar.belajarlanjutan.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azwar.belajarlanjutan.adapter.ProductAdapter
import com.azwar.belajarlanjutan.databinding.ActivityMainBinding
import com.azwar.belajarlanjutan.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

//    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var    productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(emptyList())
        mainViewModel.fatchProducts()
        setupListProduk()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupListProduk() {

        Log.e("MainActivity", "Di SetUpListProduct")
        mainViewModel.products.observe(this) {
            productAdapter = ProductAdapter(it)
            binding.rvProduct.adapter = productAdapter
            productAdapter.notifyDataSetChanged()
//            Log.e("MainActivity", "Nama : ${it.get(0).title}")
            Log.e("MainActivity", "Product Observe")
        }
    }
}