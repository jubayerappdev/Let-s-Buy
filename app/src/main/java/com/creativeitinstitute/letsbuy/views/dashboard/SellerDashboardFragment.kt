package com.creativeitinstitute.letsbuy.views.dashboard

import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellerDashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    @Inject
    lateinit var jAuth: FirebaseAuth
    override fun setListener() {

        binding.apply {
            btnLogout.setOnClickListener {
                jAuth.signOut()

                findNavController().navigate(R.id.action_sellerDashboardFragment_to_startFragment2)

            }
        }
    }

    override fun allObserver() {

    }


}