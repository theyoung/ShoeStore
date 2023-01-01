package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.create.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }
}