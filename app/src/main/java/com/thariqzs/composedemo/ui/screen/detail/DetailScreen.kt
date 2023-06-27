package com.thariqzs.composedemo.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.thariqzs.composedemo.R
import com.thariqzs.composedemo.data.ShoeSale
import com.thariqzs.composedemo.di.Injection
import com.thariqzs.composedemo.ui.ViewModelFactory
import com.thariqzs.composedemo.ui.common.UiState
import com.thariqzs.composedemo.ui.screen.detail.DetailShoeViewModel
import com.thariqzs.composedemo.utils.formatDate

@RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailContent(data: ShoeSale, onClickBack: () -> Unit) {
    val formattedDate = formatDate(data.addedAt)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .zIndex(10f)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back icon",
            modifier = Modifier
                .padding(16.dp)
                .clickable { onClickBack() }
        )
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(data.imageData),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = data.shoeName,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                lineHeight = 42.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row(Modifier) {
                    Text(text = "Price: ")
                    Text(text = data.price.toString() + "$")
                }
                Row(Modifier) {
                    Text(text = "Sold: ")
                    Text(text = data.quantitySold.toString())
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = formattedDate, textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = data.description, textAlign = TextAlign.Center)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun DetailPreview() {
    DetailContent(data = ShoeSale(
        19,
        "Lacoste Carnaby Evo",
        89.99,
        11,
        989.89,
        "2023-06-04 10:15:00",
        "Tennis-inspired sneakers with a clean and classic look.", R.drawable.img_shoe_1
    ), onClickBack = {})
}