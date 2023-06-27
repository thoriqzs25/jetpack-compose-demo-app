package com.thariqzs.composedemo.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thariqzs.composedemo.data.ShoeRepository
import com.thariqzs.composedemo.data.ShoeSale
import com.thariqzs.composedemo.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailShoeViewModel(private val repository: ShoeRepository): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<ShoeSale>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<ShoeSale>>
        get() = _uiState

    fun getShoeById(shoeId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getShoeDetailById(shoeId))
        }
    }
}