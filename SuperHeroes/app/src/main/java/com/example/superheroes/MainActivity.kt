package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroes.data.Superhero
import com.example.superheroes.data.superheroes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.marvel),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun SuperheroesApp() {
    Scaffold(
        topBar = {
            SuperheroTopAppBar()
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        ) {
            // Removed the Spacer and the Text that displayed "Woman Superheroes"
            items(superheroes) { superhero ->
                SuperheroItem(superhero)
            }
        }
    }
}


@Composable
fun SuperheroInformation(name: String, age: Int, superpower: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))) {
        Text(
            text = name,
            style = MaterialTheme.typography.displayMedium.copy(fontSize = 18.sp),  // Set a smaller font size directly
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(id = R.string.superhero_age, age),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(id = R.string.superhero_power, superpower),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun SuperheroItem(superhero: Superhero, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(vertical = dimensionResource(id = R.dimen.padding_small))  // Reduced space between cards
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_large))  // Add horizontal padding to reduce width
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))  // Increase internal padding
                .height(80.dp)  // Increase the height to make the card bigger
        ) {
            SuperheroIcon(superhero.imageResId)
            SuperheroInformation(superhero.name, superhero.age, superhero.superpower)
        }
    }
}

@Composable
fun SuperheroIcon(@DrawableRes superheroImageRes: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(superheroImageRes),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size_large))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),  // Apply circular shape
        contentScale = ContentScale.Crop  // Crop the image to fit the shape
    )
}

@Preview
@Composable
fun SuperheroesDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroesApp()
    }
}
