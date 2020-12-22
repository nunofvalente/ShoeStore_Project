package com.udacity.shoestore.screens.shoestore

import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeStoreBinding
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeStoreFragment : Fragment() {

    private val activityViewModel: ActivityViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_store, container, false)
        setHasOptionsMenu(true)

        val callback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()!!.navigate(ShoeStoreFragmentDirections.actionShoeStoreFragmentToLoginFragment())
            }
        }

        if(activityViewModel.hasLoggedIn.value == true) {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback )
        }

        activityViewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            for(shoe in shoeList) {
                inflateShoe(shoe)
            }
        })

        binding.fabAddShoe.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeStoreFragment_to_detailFragment))


        return binding.root
    }

    private fun inflateShoe(shoe: Shoe) {
        val shoeBinding: ShoeItemLayoutBinding = ShoeItemLayoutBinding.inflate(layoutInflater, binding.linearShoeContainer, true)
        shoeBinding.shoe = shoe
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
           if(item.itemId == R.id.menu_logout) {
            view?.findNavController()!!.navigate(ShoeStoreFragmentDirections.actionShoeStoreFragmentToLoginFragment())
               activityViewModel.resetValue()
               return true
        }
        return false
    }
}