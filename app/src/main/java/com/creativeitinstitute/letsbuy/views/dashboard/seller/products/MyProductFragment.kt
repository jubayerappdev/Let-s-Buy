package com.creativeitinstitute.letsbuy.views.dashboard.seller.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.core.DataState
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.databinding.FragmentMyProductBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProductFragment : BaseFragment<FragmentMyProductBinding>(FragmentMyProductBinding::inflate) {


    private val viewModel : ProductViewModel by viewModels()

    override fun setListener() {



        FirebaseAuth.getInstance().currentUser?.let {


            viewModel.getProductByID(it.uid)

        }

    }

    override fun allObserver() {

        viewModel.productResponse.observe(viewLifecycleOwner){


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
        binding.rvSeller.adapter = SellerProductAdapter(it)





    }

}