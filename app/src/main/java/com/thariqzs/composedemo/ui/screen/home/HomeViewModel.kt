package com.thariqzs.composedemo.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thariqzs.composedemo.data.ShoeRepository
import com.thariqzs.composedemo.data.ShoeSale
import com.thariqzs.composedemo.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ShoeRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<ShoeSale>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<ShoeSale>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllRewards()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }
}