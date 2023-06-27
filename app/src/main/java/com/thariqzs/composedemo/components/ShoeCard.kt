package com.thariqzs.composedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thariqzs.composedemo.R
import com.thariqzs.composedemo.data.ShoeSale

@Composable
fun ShoeCard(data: ShoeSale, onClick: (Int) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(12.dp))
            .background(
                Color.Blue.copy(0.1f), RoundedCornerShape(12.dp)
            )
            .clickable { onClick(data.id) }
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(data.imageData),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(400.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(Modifier.height(8.dp))

        Text(text = data.shoeName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(Modifier.height(8.dp))
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

    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    ShoeCard(
        data = ShoeSale(
            19,
            "Lacoste Carnaby Evo",
            89.99,
            11,
            989.89,
            "2023-06-04 10:15:00",
            "Tennis-inspired sneakers with a clean and classic look."
        ,R.drawable.img_shoe_1
        )

    , onClick = {}
    )
}