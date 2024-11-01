package com.senaaksoy.jettipapp.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.senaaksoy.jettipapp.R
import com.senaaksoy.jettipapp.icon.RoundIconButton

@Composable
fun EditBox(onTotalChange: (Float) -> Unit){
    var input by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0f) }
    var splitCount by remember { mutableStateOf(1) }

    val tipPercentage = (sliderPosition * 100).toInt()
    val billAmount = input.toFloatOrNull() ?: 0f //if input is null,then billAmount is accepted 0
    val tipAmount = (billAmount * tipPercentage) / 100
    val totalPerPerson = (billAmount + tipAmount) / splitCount

    onTotalChange(totalPerPerson)

    Box(modifier = Modifier
    .padding(8.dp)
    .border(
        BorderStroke(width = 2.dp, color = Color.LightGray),
        shape = RoundedCornerShape(12.dp)
    )
    .height(300.dp)
    .fillMaxWidth()
    ){
    Column(modifier = Modifier.padding(10.dp)){
        OutlinedTextField(
            value = input,
            onValueChange = {input=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            label={Text(text = stringResource(id = R.string.enter_bill ))},
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.icons8_dollar_32), contentDescription =null,
                    modifier = Modifier.size(24.dp))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            )
        )
        if(input.isNotEmpty()){
Column{
Row(horizontalArrangement = Arrangement.Start) {
    Text(text = stringResource(id = R.string.split))
    Spacer(modifier = Modifier.width(120.dp))
RoundIconButton(iconResourceId = R.drawable.icons8_minus_24){
    if(splitCount<=1)
splitCount-=1
}
    Spacer(modifier = Modifier.width(10.dp))
    Text(text=splitCount.toString())
    Spacer(modifier = Modifier.width(10.dp))
    RoundIconButton(iconResourceId = R.drawable.icons8_plus_24){
        splitCount+=1
    }
}
    Spacer(modifier = Modifier.height(28.dp))
    Row {
        Text(text = stringResource(id = R.string.tip))
        Spacer(modifier = Modifier.width(128.dp))
        Text(text = "\$${"%.2f".format(tipAmount)}")
    }
    Spacer(modifier = Modifier.height(28.dp))
    Text(text = "$tipPercentage%",modifier=Modifier.padding(start = 128.dp))
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        modifier = Modifier.padding(horizontal = 12.dp),
        steps = 5,

    )

}
        }
    }
   

}

}