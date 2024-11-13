package com.rest.restartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rest.restartspace.ui.theme.Green80
import com.rest.restartspace.ui.theme.LightGreen40
import com.rest.restartspace.ui.theme.Olive80
import com.rest.restartspace.ui.theme.RestArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestArtSpaceMain()
                }
            }
        }
    }
}

data class Content(
    val artPicture: Painter,
    val artTitle: String,
    val artistName: String,
)

@Composable
fun getContent(imageNumber: Int): Content {
    return when (imageNumber) {
        1 -> Content(
            artPicture = painterResource(R.drawable.edvardmunch),
            artTitle = stringResource(R.string.TEdvardMunch),
            artistName = stringResource(id = R.string.EdvardMunch)
        )

        2 -> Content(
            artPicture = painterResource(R.drawable.johannes),
            artTitle = stringResource(R.string.TJohannes),
            artistName = stringResource(id = R.string.JohannesVermeer)
        )

        3 -> Content(
            artPicture = painterResource(R.drawable.georges),
            artTitle = stringResource(R.string.TGeorgesSeurat),
            artistName = stringResource(id = R.string.George)
        )

        4 -> Content(
            artPicture = painterResource(R.drawable.selfportrait),
            artTitle = stringResource(R.string.TSelfPortrait),
            artistName = stringResource(id = R.string.SelfPortrait)
        )

        5 -> Content(
            artPicture = painterResource(R.drawable.eugenedelacroix),
            artTitle = stringResource(R.string.TEugeneDelacroix),
            artistName = stringResource(id = R.string.EugeneDelacroix)
        )

        else -> Content(
            artPicture = painterResource(R.drawable.jean_antoine),
            artTitle = stringResource(R.string.TJeanAntoine),
            artistName = stringResource(id = R.string.JeanAntoine)
        )
    }
}

@Composable
fun RestArtSpaceMain() {
    var imageNumber by remember { mutableIntStateOf(0) }

    val content = getContent(imageNumber = imageNumber)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            ArtImage(artPicture = content.artPicture)

            Spacer(modifier = Modifier.height(32.dp))

            ArtCard(artTitle = content.artTitle, artistName = content.artistName)

            Spacer(modifier = Modifier.height(32.dp))

            ArtButtons(onClick = { imageNumber = (imageNumber + it + 6) % 6 }
            )
        }
    }
}

@Composable
fun ArtImage(artPicture: Painter) {
    Image(
        painter = artPicture,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .border(border = BorderStroke(2.dp, Green80), shape = RectangleShape)
            .shadow(elevation = 4.dp)
            .padding(10.dp)
    )
}

@Composable
fun ArtCard(artTitle: String, artistName: String) {
    Card(modifier = Modifier.fillMaxWidth().height(120.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightGreen40)
                .padding(16.dp)
        ) {
            Text(
                text = artTitle,
                fontSize = 25.sp,
                textAlign = TextAlign.Start,
                lineHeight = 30.sp
            )
            Text(
                text = artistName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun ArtButtons(onClick: (num: Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { onClick(-1) },
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Olive80),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.prev), color = Color.Black)
        }

        Spacer(modifier = Modifier.width(24.dp))

        Button(
            onClick = { onClick(+1) },
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Olive80),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.next), color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestArtSpaceTheme {
        RestArtSpaceMain()
    }
}