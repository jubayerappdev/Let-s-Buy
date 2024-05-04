package com.creativeitinstitute.letsbuy.views.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.base.BaseFragment
import com.creativeitinstitute.letsbuy.databinding.FragmentLoginBinding
import com.creativeitinstitute.letsbuy.isEmpty


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {




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
                }
            }
        }
    }

    override fun allObserver() {
        TODO("Not yet implemented")
    }


}