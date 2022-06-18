package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleWithImage(
                        header = stringResource(id = R.string.header_text),
                        text1 = stringResource(id = R.string.article_text1),
                        text2 = stringResource(id = R.string.article_text2)
                    )
                }
            }
        }
    }
}


@Composable
fun ArticleWithoutImage(header: String, text1: String, text2: String) {

    Column {
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        Text(
            text = text1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = text2,
            modifier = Modifier.padding(all = 16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun ArticleWithImage(header: String, text1: String, text2: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column{
        Box {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                ,
                contentScale = ContentScale.Crop,
            )
        }
        Box {
            ArticleWithoutImage(header = header, text1 = text1, text2 = text2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleWithImagePreveiew() {
    ArticleWithImage(
        header = stringResource(id = R.string.header_text),
        text1 = stringResource(id = R.string.article_text1),
        text2 = stringResource(id = R.string.article_text2)
    )
}

@Composable
fun Obrazok() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Preview
@Composable
fun ObrazokPreview() {
    Obrazok()
}

@Preview(showBackground = false)
@Composable
fun ArticleWithoutImage() {
    ArticleWithoutImage(
        header = stringResource(id = R.string.header_text),
        text1 = stringResource(id = R.string.article_text1),
        text2 = stringResource(id = R.string.article_text2)
    )
}


