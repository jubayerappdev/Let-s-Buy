package com.creativeitinstitute.letsbuy.views.dashboard.seller.profile

import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.creativeitinstitute.letsbuy.core.DataState
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.data.repository.AuthRepository
import com.creativeitinstitute.letsbuy.data.repository.SellerProfileRepository
import com.creativeitinstitute.letsbuy.data.repository.SellerRepository
import com.creativeitinstitute.letsbuy.views.login.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SellerProfileViewModel @Inject constructor(private val repo: SellerProfileRepository):ViewModel(){

    private val _productUploadResponse = MutableLiveData<DataState<String>>()
    val productUploadResponse : LiveData<DataState<String>> = _productUploadResponse

    fun updateProfile(user: SellerProfile){

        _productUploadResponse.postValue(DataState.Loading())

        val imageUri : Uri = user.userImage.toUri()

        repo.uploadImage(imageUri).addOnSuccessListener {snapshot->


            snapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener {url ->

                user.userImage = url.toString()


                repo.updateUser(user)
                    .addOnSuccessListener {
                        _productUploadResponse.postValue(DataState.Success(
                            "Uploaded and Updated user Profile Successfully !"
                        ))
                    }.addOnFailureListener {
                        _productUploadResponse.postValue(DataState.Error("${it.message}"))
                    }


//                _productUploadResponse.postValue(DataState.Success(
//                    url.toString()
//                ))

            }


        }.addOnFailureListener {
            _productUploadResponse.postValue(DataState.Error("Image Uploaded fail"))
        }





//        repo.uploadProductImage()
//
//        repo.userLogin(user).addOnSuccessListener {
//            _loginResponse.postValue(DataState.Success(user))
//
//            Log.d("TAG", "login: Success ")
//        }.addOnFailureListener { error->
//            _loginResponse.postValue(DataState.Error("${error.message}"))
//
//            Log.d("TAG", "userLogin: ${error.message}")
//        }

    }
}