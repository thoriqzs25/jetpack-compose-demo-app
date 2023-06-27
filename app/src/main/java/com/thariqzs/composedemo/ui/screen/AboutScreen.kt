package com.thariqzs.composedemo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.thariqzs.composedemo.R

@Composable
fun AboutScreen(navController: NavController) {
    AboutContent(navigateBack = { navController.navigateUp() })
}

@Composable
fun AboutContent(
    navigateBack: () -> Unit,
) {
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
                .clickable { navigateBack() }
        )
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.img_profile_pic),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Thariq Zhafran Satyagraha", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "thariqzs@yahoo.com")
    }
}

@Composable
@Preview(showBackground = true)
fun AboutPreview() {
    AboutContent(navigateBack = {})
}