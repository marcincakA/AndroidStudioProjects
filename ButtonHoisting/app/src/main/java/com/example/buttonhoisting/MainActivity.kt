package com.example.buttonhoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buttonhoisting.ui.theme.ButtonHoistingTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonHoistingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TlacidloTest()
                }
            }
        }
    }
}

@Composable
fun TlacidloTest() {
    var value by remember {
        mutableStateOf(2)
    }
    Column() {
        Text(text = value.toString())
        Button(
            value,
            onValueChange = { value += 1 }
            )
    }
}

@Composable
fun Button(
    value: Int,
    onValueChange: (Int) -> Unit,
) {
    var value by remember {
        mutableStateOf(0)
    }
    IconButton(
        onClick = {},
        modifier = Modifier.clickable() {
            onValueChange = onValueChange
        }
    ) {
        Icon(Icons.Filled.PlayArrow, contentDescription = "null")
    }
}

