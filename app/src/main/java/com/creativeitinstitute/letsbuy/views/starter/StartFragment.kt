package com.creativeitinstitute.letsbuy.views.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.databinding.FragmentStartBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {



     override fun setListener() {

         setUpAutoLogin()

        with(binding){
            btnLogin.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment2_to_loginFragment)
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment2_to_registerFragment)
            }
        }

    }

    private fun setUpAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let {
            findNavController().navigate(R.id.action_startFragment2_to_sellerDashboardFragment)

        }
    }

    override fun allObserver() {

    }


}