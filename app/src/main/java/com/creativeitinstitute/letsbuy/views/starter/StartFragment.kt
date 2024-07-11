package com.creativeitinstitute.letsbuy.views.starter

import android.content.Intent
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.core.Nodes
import com.creativeitinstitute.letsbuy.databinding.FragmentStartBinding
import com.creativeitinstitute.letsbuy.views.dashboard.customer.CustomerDashboard
import com.creativeitinstitute.letsbuy.views.dashboard.seller.SellerDashboard
import com.google.firebase.auth.FirebaseAuth
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
        FirebaseAuth.getInstance().currentUser?.let {data ->







            startActivity(Intent(requireContext(), SellerDashboard::class.java))
            requireActivity().finish()

        }
    }

    override fun allObserver() {

    }


}