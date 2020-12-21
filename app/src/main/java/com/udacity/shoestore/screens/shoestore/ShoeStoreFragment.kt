package com.udacity.shoestore.screens.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeStoreBinding

class ShoeStoreFragment : Fragment() {

    private val activityViewModel: ActivityViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_store, container, false)
        setHasOptionsMenu(true)
        activityViewModel.login()

        return binding.root
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