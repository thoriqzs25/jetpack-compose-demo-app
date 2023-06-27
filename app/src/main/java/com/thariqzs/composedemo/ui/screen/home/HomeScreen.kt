package com.thariqzs.composedemo.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
                    onClick = { navController.navigate(Screen.DetailShoe.createRoute(it)) },
                    onClickProfile = { navController.navigate(Screen.About.route) }
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
    onClick: (Int) -> Unit,
    onClickProfile: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .zIndex(10f)
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "back icon",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterEnd)
                .clickable { onClickProfile() }
        )
    }
    LazyColumn(
        contentPadding = PaddingValues(top = 66.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {

        items(data) { data ->
            ShoeCard(data = data, onClick = { onClick(it) })
        }
    }
}