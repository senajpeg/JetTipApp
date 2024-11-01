package com.senaaksoy.jettipapp.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senaaksoy.jettipapp.R

@Composable
fun EditCard(totalPerPerson: Float){
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(128.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE4BCEB))
    ){
        Column(
           modifier =  Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.total_per_person),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
            Text(text = "\$${"%.2f".format(totalPerPerson)}", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }

    }
}
