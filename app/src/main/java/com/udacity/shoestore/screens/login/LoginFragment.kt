package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        binding.buttonCreateAccount.setOnClickListener {
            if (validateFields()) {
                view?.findNavController()!!.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        binding.buttonExistingAccount.setOnClickListener {
            if (validateFields()) {
                view?.findNavController()!!.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

        return binding.root
    }

    private fun validateFields(): Boolean {
        if (binding.editLoginEmail.text!!.isNotEmpty()) {
            if (binding.editLoginPassword.text!!.isNotEmpty()) {
                return true
            } else {
                Toast.makeText(requireContext(), "Please insert your password!", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Please insert your email address!",
                Toast.LENGTH_SHORT
            ).show()
        }
        return false
    }
}