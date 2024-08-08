package com.creativeitinstitute.letsbuy.views.dashboard.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.databinding.ItemProductBinding
import com.creativeitinstitute.letsbuy.databinding.ItemSellerProductBinding

class CustomerProductAdapter(val productList : List<Product>) : RecyclerView.Adapter<CustomerProductAdapter.ProductViewHolder>() {


    class ProductViewHolder( val binding:ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {

        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        productList[position].let {

            holder.binding.apply {
                txtProductName.text = it.name
                textProductDescription.text = it.description
                textProductPrice.text  = "Price: $ ${it.price}"
                textProductStock.text  = "Stock : ${it.amount}"
                ivProduct.load(it.imageLink)
            }


        }

    }


}