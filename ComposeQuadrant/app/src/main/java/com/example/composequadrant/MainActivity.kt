package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AllQuadrants(
                        Header1 = "Text composable",
                        Content1 = "Displays text and follows Material Design guidelines.",
                        Header2 = "Image composable",
                        Content2 = "Creates a composable that lays out and draws a given Painter class object.",
                        Header3 = "Row composable",
                        Content3 = "A layout composable that places its children in a horizontal sequence.",
                        Header4 = "Column composable",
                        Content4 = "A layout composable that places its children in a vertical sequence."
                    )
                }
            }
        }
    }
}

@Composable
fun AllQuadrants(Header1: String, Content1: String,
                 Header2: String, Content2: String,
                 Header3: String, Content3: String,
                 Header4: String, Content4: String) {
        Row {
            Column{
                Quadrant(Header = Header1, Content = Content1)
                Quadrant(Header = Header2, Content = Content2)
            }

            Column{
                Quadrant(Header = Header3, Content = Content3)
                Quadrant(Header = Header4, Content = Content4)
            }
        }
}

@Composable
@Preview (showBackground = true)
fun AllQuadrantsPreview() {
    AllQuadrants(
        Header1 = "Text composable",
        Content1 = "Displays text and follows Material Design guidelines.",
        Header2 = "Image composable",
        Content2 = "Creates a composable that lays out and draws a given Painter class object.",
        Header3 = "Row composable",
        Content3 = "A layout composable that places its children in a horizontal sequence.",
        Header4 = "Column composable",
        Content4 = "A layout composable that places its children in a vertical sequence."
    )
}

@Composable
fun Quadrant(Header: String, Content: String) {
    val config = LocalConfiguration.current
    val screenHeight = config.screenHeightDp / 2
    val screenWidth = config.screenWidthDp / 2
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .size(width = screenHeight.dp,
                height = screenWidth.dp),
        ) {
        Text(
            text = Header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            )
        Text(
            text = Content,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
@Preview (showBackground = true)
fun QuadrantPreview() {
    Quadrant(Header = "Text composable", Content = "text dsaljkfdaslkflksdfjkla")
}