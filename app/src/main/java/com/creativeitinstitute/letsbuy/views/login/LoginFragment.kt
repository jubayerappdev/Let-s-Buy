package com.creativeitinstitute.letsbuy.views.login

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.core.DataState
import com.creativeitinstitute.letsbuy.core.Nodes
import com.creativeitinstitute.letsbuy.databinding.FragmentLoginBinding
import com.creativeitinstitute.letsbuy.isEmpty
import com.creativeitinstitute.letsbuy.views.dashboard.customer.CustomerDashboard
import com.creativeitinstitute.letsbuy.views.dashboard.seller.SellerDashboard

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private val viewModel: LoginViewModel by viewModels()


     override fun setListener() {


        with(binding){
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context, "All input done..", Toast.LENGTH_LONG).show()

                    val user = UserLogin(etEmail.text.toString(), etPassword.text.toString())
                    viewModel.userLogin(user)
                    loading.show()
                }
            }
        }
    }

    override fun allObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message,Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
                    Toast.makeText(context, "Loading....",Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context,"User logged in : ${it.data}",Toast.LENGTH_SHORT).show()

                    it.data?.apply {
                        when (userType) {
                            Nodes.USER_TYPE_CUSTOMER -> {
                                startActivity(Intent(requireContext(), CustomerDashboard::class.java))
                                requireActivity().finish()
                            }
                            Nodes.USER_TYPE_SELLER -> {
                                startActivity(Intent(requireContext(), SellerDashboard::class.java))
                                requireActivity().finish()
                            }
                            else -> {
                                Toast.makeText(requireContext(), "Something wnt wrong!", Toast.LENGTH_LONG).show()
                            }
                        }


                    }

                }
            }
        }

    }


}