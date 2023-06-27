package com.thariqzs.composedemo.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.thariqzs.composedemo.components.ShoeCard
import com.thariqzs.composedemo.data.ShoeSale
import com.thariqzs.composedemo.di.Injection
import com.thariqzs.composedemo.ui.ViewModelFactory
import com.thariqzs.composedemo.ui.common.UiState
import com.thariqzs.composedemo.ui.nav.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navController: NavController
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllRewards()
            }
            is UiState.Success -> {
                HomeContent(
                    data = uiState.data,
                    modifier = modifier,
                    onClick = {navController.navigate(Screen.DetailShoe.createRoute(it))}
//                    onClick = { Log.d("hsthoriq", "HomeScreen: $it")}
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    data: List<ShoeSale>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(data) { data ->
            ShoeCard(data = data, onClick = { onClick(it) })
//            RewardItem(
//                image = data.reward.image,
//                title = data.reward.title,
//                requiredPoint = data.reward.requiredPoint,
//                modifier = Modifier.clickable {
//                    navigateToDetail(data.reward.id)
//                }
//            )
        }
    }
}