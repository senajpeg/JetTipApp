package com.senaaksoy.jettipapp.icon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier


@Composable
fun RoundIconButton(iconResourceId:Int,onClick: () -> Unit){
    Box(modifier=Modifier
        .border(
            BorderStroke(width = 2.dp, color = Color.LightGray),
            shape = RoundedCornerShape(12.dp)
        )
        .clickable(onClick = onClick)
        ){
        Icon(painter = painterResource(id = iconResourceId),
            contentDescription = null,
            modifier = Modifier.size(24.dp))
    }

}