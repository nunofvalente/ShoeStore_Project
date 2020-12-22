package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    var shoe: Shoe = Shoe("", 0.0, "", "", mutableListOf())
        get() = field.apply {
            name = shoeName.value!!
            size = shoeSize.value?.toDouble() ?: 0.0
            company = shoeCompany.value!!
            description = shoeDescription.value!!
            images = listOf("https://www.footasylum.com/images/products/large/005791.jpg")
        }

    private var mShoeList: MutableList<Shoe> = mutableListOf()
    private var _hasLoggedIn = MutableLiveData<Boolean>()
    val hasLoggedIn: LiveData<Boolean>
        get() = _hasLoggedIn

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _hasLoggedIn.value = false
        mShoeList = getList() as MutableList<Shoe>
        _shoeList.value = mShoeList
    }


    private fun getList(): List<Shoe> {
        val mImageListSneakers =
            listOf("https://www.footasylum.com/images/products/large/005791.jpg")
        val mImageListShoe =
            listOf("https://media.tedbaker.com/t_xld_pdp_primary,q_auto:best,f_auto/Product/Mens/241236_BLACK_1?")

        val shoe1 = Shoe("Air Force", 41.5, "Nike", "Comfortable", mImageListSneakers)
        val shoe2 = Shoe("Samba", 40.0, "Adidas", "Blue color and super comfy", mImageListSneakers)
        val shoe3 = Shoe("Leather Derby", 39.5, "Ted Baker", "Black and Shiny", mImageListShoe)

        mShoeList.add(shoe1)
        mShoeList.add(shoe2)
        mShoeList.add(shoe3)

        return mShoeList
    }

    fun login() {
        _hasLoggedIn.value = true
    }

    fun resetValue() {
        _hasLoggedIn.value = false
    }

    fun addToList() {
        val mShoe = shoe
        mShoeList.add(mShoe)
        _shoeList.value = mShoeList
    }
}