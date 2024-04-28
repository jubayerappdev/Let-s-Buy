package com.creativeitinstitute.letsbuy.views.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.creativeitinstitute.letsbuy.R
import com.creativeitinstitute.letsbuy.databinding.FragmentRegisterBinding
import com.creativeitinstitute.letsbuy.isEmpty


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        setListener()
        return binding.root
    }

    private fun setListener() {


        with(binding){
            btnRegister.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    Toast.makeText(context,"All input done !", Toast.LENGTH_LONG).show()
                }

            }
        }
    }


}