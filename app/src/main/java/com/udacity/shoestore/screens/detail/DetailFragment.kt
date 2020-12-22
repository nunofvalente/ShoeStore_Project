package com.udacity.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val activityViewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.buttonDetailCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_shoeStoreFragment))
        binding.buttonDetailSave.setOnClickListener { view: View ->
            activityViewModel.addToList()
            view.findNavController().navigate(R.id.action_detailFragment_to_shoeStoreFragment)
        }
    }


}