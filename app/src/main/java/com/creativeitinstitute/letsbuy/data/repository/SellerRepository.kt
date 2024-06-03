package com.creativeitinstitute.letsbuy.data.repository

import android.net.Uri
import com.creativeitinstitute.letsbuy.data.Product
import com.creativeitinstitute.letsbuy.data.models.SellerSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import javax.inject.Inject

class SellerRepository @Inject constructor(
    private val db: FirebaseFirestore,
    private val storageRef: StorageReference
) : SellerSource {
    override fun uploadProductImage(productImageUri: Uri) :UploadTask{

        val storage: StorageReference = storageRef.child("products").child("PRD_${System.currentTimeMillis()}")

       return storage.putFile(productImageUri)

    }

    override fun uploadProduct(product: Product) {

    }
}