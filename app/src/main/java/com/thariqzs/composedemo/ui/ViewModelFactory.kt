package com.thariqzs.composedemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thariqzs.composedemo.data.ShoeRepository
import com.thariqzs.composedemo.ui.screen.detail.DetailShoeViewModel
import com.thariqzs.composedemo.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: ShoeRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailShoeViewModel::class.java)) {
            return DetailShoeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}