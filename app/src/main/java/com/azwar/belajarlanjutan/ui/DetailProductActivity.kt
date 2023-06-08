package com.azwar.belajarlanjutan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.azwar.belajarlanjutan.databinding.ActivityDetailProductBinding
import com.azwar.belajarlanjutan.viewmodel.DetailProductViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding

    @Inject
    lateinit var detailProductViewModel: DetailProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getIntExtra("product_id", 0)
        detailProductViewModel.fatchProduct(id)
        iniData()
        view()
    }

    private fun view() {
        binding.cvCategory.setOnClickListener {
            Toast.makeText(this, "Click Category", Toast.LENGTH_SHORT).show()
        }
    }

    private fun iniData() {
        detailProductViewModel.product.observe(this){
            binding.tvTitle.setText(it.title ?: "-")
            binding.tvBrand.setText(it.brand ?: "-")
            binding.tvPrice.setText("$${it.price ?: "-"}")
            binding.tvRating.setText(it.rating.toString() ?: "-")
            binding.tvCategory.setText(it.category ?: "-")
            binding.tvDescription.setText(it.description ?: "-")
            
            Glide.with(this)
                .load(it.thumbnail)
                .centerCrop()
                .into(binding.imgThubnail)
            
        }
        
    }
}