package com.example.platrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.extendsdailytasks.product1
import com.example.platrow.R
import com.example.platrow.model.Product
import com.example.platrow.ui.theme.MainColor
import com.example.platrow.ui.theme.Red700
import com.example.platrow.ui.theme.dividerColor


@Composable
fun OrderItem(product: Product){

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)) {
        Image(painter =
        rememberImagePainter(data = product.listImageUrl[1]),
            contentDescription = null)

        Column {
            Text(text = product.name)
            Text(text = product.wieght)
            Text(text = product.calories)
            Incrementer(product = product)
        }
    }
}

@Composable
fun Incrementer (product : Product){

    var itemNumber by  rememberSaveable {
        mutableStateOf("")
    }
    itemNumber = "1"
    var number = 1

    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(8.dp))
        .height(24.dp)
        .background(color = dividerColor)) {
        IconButton(modifier = Modifier.
        then(Modifier.size(24.dp)),
            onClick = { number += 1
                itemNumber = number.toString()}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                "contentDescription")
        }

        Text(text = itemNumber, modifier = Modifier
            .padding(start = 8.dp, end = 8.dp), textAlign = TextAlign.Center
            , fontSize = 18.sp)


        IconButton(modifier = Modifier.
        then(Modifier.size(24.dp)),
            onClick = {number -= number
                itemNumber = number.toString()}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_horizontal_rule_24),
                "contentDescription")
        }

        Text(text = product.price,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 24.sp, color = MainColor)
    }
}

@Composable
fun AddproductFromWIshLis(){
    Row {
        IconButton(modifier = Modifier
            .then(Modifier.size(24.dp))
            .padding(
                start = 24.dp,
                top = 18.dp, end = 20.dp
            ),
            onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.add_circular_button_thin_symbol),
                "contentDescription")
        }
        Text(text = "Add new products from wishList", color = Red700,
            fontSize = 24.sp, modifier = Modifier.padding(start = 24.dp, top = 18.dp))
    }
}

@Composable
fun PaymentDetails(){

    Card(modifier = Modifier.background(color = Color.White),
        shape = RoundedCornerShape(16.dp)) {

        Column(modifier = Modifier.padding(16.dp)
            .background(color = Color.White)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sub Total", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 24.dp))
                Text(text = "48.00 SAR", fontSize = 18.sp,
                    modifier = Modifier.padding(end = 24.dp))
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Delivery Fees", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 24.dp))
                Text(text = "10.00 SAR", fontSize = 18.sp,
                    modifier = Modifier.padding(end = 24.dp))
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Total", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 24.dp))
                Text(text = "58.00 SAR", fontSize = 18.sp,
                    modifier = Modifier.padding(end = 24.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showMycartVIew(){
    //OrderItem(product = product1)
    //AddproductFromWIshLis()
    PaymentDetails()
}