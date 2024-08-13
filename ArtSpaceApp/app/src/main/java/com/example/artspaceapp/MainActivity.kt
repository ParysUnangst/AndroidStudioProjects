package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

data class Artwork(
    val title: String,
    val artist: String,
    val year: String,
    val imageResId: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork("Guest Post Famous Woman", "Frida Kahlo", "1938", R.drawable.image1),
        Artwork("Girl With a Pearl Earring", "Johannes Vermeer", "1665", R.drawable.image2),
        Artwork("Lili with a Feather Fan", "Gerda Wegener", "1920", R.drawable.image3),
        Artwork("Woman with Fan", "Gustav Klimt", "1918", R.drawable.image4),
        Artwork("The Birth Of Venus", "Sandro Botticelli", "1482-1486", R.drawable.image5)
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val currentArtwork = artworks[currentIndex]
        Image(
            painter = painterResource(id = currentArtwork.imageResId),
            contentDescription = currentArtwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = currentArtwork.title, style = MaterialTheme.typography.titleLarge)
        Text(text = currentArtwork.artist, style = MaterialTheme.typography.titleMedium)
        Text(text = currentArtwork.year, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                } else {
                    currentIndex = artworks.size - 1
                }
            }) {
                Text("Previous")
            }

            Button(onClick = {
                if (currentIndex < artworks.size - 1) {
                    currentIndex++
                } else {
                    currentIndex = 0
                }
            }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}
