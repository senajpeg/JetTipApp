package com.senaaksoy.jettipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.senaaksoy.jettipapp.ui.theme.JetTipAppTheme
import com.senaaksoy.jettipapp.widgets.EditBox
import com.senaaksoy.jettipapp.widgets.EditCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetTipAppTheme {
               Surface(modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background) {
                   JetTipApp()
               }
                }
            }
        }
    }

@Composable
fun JetTipApp(){
    var totalPerPerson by remember { mutableStateOf(0f) }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        EditCard(totalPerPerson = totalPerPerson)
        EditBox(onTotalChange = {newTotal->
            totalPerPerson=newTotal

        })

    }
}

@Preview(showBackground = true)
@Composable
fun JetTipAppPreview() {
    JetTipAppTheme {
      JetTipApp()
    }
}