package com.azwar.belajarlanjutan.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azwar.belajarlanjutan.databinding.ItemProductBinding
import com.azwar.belajarlanjutan.model.Product
import com.azwar.belajarlanjutan.ui.DetailProductActivity
import com.bumptech.glide.Glide

class ProductAdapter(private var products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.MyHolderVIew>() {
    class MyHolderVIew(private var binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(get: Product) {
            with(itemView) {

                binding.tvTitle.setText(get.title ?: "-")
                binding.tvDescription.setText(get.description ?: "-")
                binding.tvPrice.setText("$${get.price ?: "0"}")
                binding.tvRating.setText(get.rating.toString())

                Glide.with(context)
                    .load(get.thumbnail)
                    .centerCrop()
                    .into(binding.imgThubnail)

                itemView.setOnClickListener {
                    var intent = Intent(context, DetailProductActivity::class.java)
                    intent.putExtra("product_id", get.id)
                    context.startActivity(intent)
                }

            }
        }

    }

    fun updateData(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderVIew {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductAdapter.MyHolderVIew(binding)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: MyHolderVIew, position: Int) =
        holder.bind(products.get(position))
}