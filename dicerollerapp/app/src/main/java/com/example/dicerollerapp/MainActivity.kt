package com.example.dicerollerapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerapp.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DiceRollerApp()
                }
            }
        }
    }
}




@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(1) }
    val rollHistory = remember { mutableStateListOf<Pair<Int, Int>>() }
    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = getDiceImageResource(result1)),
                contentDescription = result1.toString(),
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = getDiceImageResource(result2)),
                contentDescription = result2.toString(),
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result1 = (1..6).random()
            result2 = (1..6).random()
            rollHistory.add(result1 to result2)  // Add to history
            MediaPlayer.create(context, R.raw.roll).start()  // Play sound
        }) {
            Text(text = stringResource(id = R.string.roll))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Roll History:", style = MaterialTheme.typography.headlineMedium)
        LazyColumn {
            items(rollHistory) { roll ->
                Text(text = "Rolled: ${roll.first}, ${roll.second}")
            }
        }
    }
}

@Composable
fun getDiceImageResource(result: Int): Int {
    return when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Preview
@Composable
fun DiceRollerPreview() {
    DiceRollerTheme {
        DiceRollerApp()
    }
}
