package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }

    val (text, imageRes) = when (currentStep) {
        1 -> Pair(
            stringResource(id = R.string.lemon_tree_instruction),
            R.drawable.lemon_tree
        )
        2 -> Pair(
            stringResource(id = R.string.squeeze_instruction),
            R.drawable.lemon_squeeze
        )
        3 -> Pair(
            stringResource(id = R.string.drink_instruction),
            R.drawable.lemon_drink
        )
        else -> Pair(
            stringResource(id = R.string.restart_instruction),
            R.drawable.lemon_restart
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(id = when (currentStep) {
                1 -> R.string.lemon_tree_content_description
                2 -> R.string.lemon_content_description
                3 -> R.string.glass_of_lemonade_content_description
                else -> R.string.empty_glass_content_description
            }),
            modifier = Modifier
                .size(150.dp)
                .clickable {
                    currentStep = (currentStep % 4) + 1
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
