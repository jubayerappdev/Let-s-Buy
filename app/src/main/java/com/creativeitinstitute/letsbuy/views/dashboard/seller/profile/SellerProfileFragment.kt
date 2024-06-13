package com.creativeitinstitute.letsbuy.views.dashboard.seller.profile

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.core.areAllPermissionsGranted
import com.creativeitinstitute.letsbuy.core.requestPermissions
import com.creativeitinstitute.letsbuy.databinding.FragmentSellerProfileBinding
import com.creativeitinstitute.letsbuy.views.dashboard.seller.upload.UploadProductFragment
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellerProfileFragment : BaseFragment<FragmentSellerProfileBinding>(FragmentSellerProfileBinding::inflate) {


    val viewModel : SellerProfileViewModel by viewModels()


    override fun setListener() {
        permissionsRequest = getPermissionsRequest()
       binding.apply {
           ivProfile.setOnClickListener {
               requestPermissions(permissionsRequest, permissionList)


           }
       }
    }

    override fun allObserver() {

    }
    companion object{
        private val permissionList = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }

    private lateinit var permissionsRequest: ActivityResultLauncher<Array<String>>


    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                Log.d("TAG", "$fileUri")
                binding.ivProfile.setImageURI(fileUri)



            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    private fun getPermissionsRequest(): ActivityResultLauncher<Array<String>> {

        return  registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

            if (areAllPermissionsGranted(permissionList)){



                //ase
                Toast.makeText(requireContext(), "Ase", Toast.LENGTH_LONG).show()

                ImagePicker.with(this)
                    .compress(1024)         //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(512, 512)  //Final image resolution will be less than 1080 x 1080(Optional)
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }


            }else{
                //nai
                Toast.makeText(requireContext(), "nai", Toast.LENGTH_LONG).show()


            }


        }

    }
}