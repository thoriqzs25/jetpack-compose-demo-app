package com.thariqzs.composedemo.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.thariqzs.composedemo.data.ShoeSale
import com.thariqzs.composedemo.di.Injection
import com.thariqzs.composedemo.ui.ViewModelFactory
import com.thariqzs.composedemo.ui.common.UiState
import com.thariqzs.composedemo.ui.screen.detail.DetailShoeViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    navigateBack: () -> Unit,
    shoeId: Int,
    viewModel: DetailShoeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository()))
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getShoeById(shoeId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data,
                    onClickBack = { navigateBack() }
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(data: ShoeSale, onClickBack: () -> Unit) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back icon",
            modifier = Modifier
                .padding(16.dp)
                .clickable { onClickBack() }
        )
        Text(text = data.shoeName)
        Text(text = data.price.toString())
        Text(text = data.quantitySold.toString())
        Text(text = data.addedAt)
        Text(text = data.description)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    DetailContent(data = ShoeSale(
        19,
        "Lacoste Carnaby Evo",
        89.99,
        11,
        989.89,
        "2023-06-04 10:15:00",
        "Tennis-inspired sneakers with a clean and classic look."
    ), onClickBack = {})
}