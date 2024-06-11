package com.creativeitinstitute.letsbuy.views.dashboard.seller.products

import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.creativeitinstitute.letsbuy.core.DataState
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.data.repository.AuthRepository
import com.creativeitinstitute.letsbuy.data.repository.SellerRepository
import com.creativeitinstitute.letsbuy.views.login.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: SellerRepository):ViewModel(){

    private val _productResponse = MutableLiveData<DataState<List<Product>>>()
    val productResponse : LiveData<DataState<List<Product>>> = _productResponse

    fun getProductByID(userID:String){

        _productResponse.postValue(DataState.Loading())


        repo.getAllProductByUserID(userID).addOnSuccessListener { document ->

            val productList = mutableListOf<Product>()

            document.documents.forEach { doc->


                val product = doc.toObject(Product::class.java)?.let {
                    productList.add(it)
                }

            }

            _productResponse.postValue(DataState.Success(productList))




        }.addOnFailureListener {

            _productResponse.postValue(DataState.Error("${it.message}"))

        }



    }
}