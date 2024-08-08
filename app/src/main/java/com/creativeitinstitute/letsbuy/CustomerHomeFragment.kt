package com.creativeitinstitute.letsbuy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.core.DataState
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.databinding.FragmentCustomerHomeBinding
import com.creativeitinstitute.letsbuy.views.dashboard.customer.CustomerProductAdapter
import com.creativeitinstitute.letsbuy.views.dashboard.customer.ProductViewModelCustomer
import com.creativeitinstitute.letsbuy.views.dashboard.seller.products.SellerProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerHomeFragment : BaseFragment<FragmentCustomerHomeBinding>(FragmentCustomerHomeBinding::inflate){

    private  val viewmodel: ProductViewModelCustomer by viewModels()

    override fun setListener() {

    }

    override fun allObserver() {
        viewmodel.productResponse.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error->{

                    loading.dismiss()
                }
                is DataState.Loading -> {
                    loading.show()

                }
                is DataState.Success ->{
                    it.data?.let { it1 ->setDataToRV(it1) }
                    loading.dismiss()

                }
            }
        }

    }
    private fun setDataToRV(it: List<Product>) {
        binding.rvCustomerProduct.adapter = CustomerProductAdapter(it)





    }


}