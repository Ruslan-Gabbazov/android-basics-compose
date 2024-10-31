package com.rest.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rest.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            AppHeader(modifier = modifier)
            ContentWrapper(modifier = modifier)
        }
    }
}

@Composable
fun AppHeader(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(92.dp)
            .background(color = Color.Yellow)
            .fillMaxWidth()
    ) {
        Text(
            text = "Lemonade",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = modifier
                .align(Alignment.Center)
                .padding(top = 20.dp),
        )
    }
}

data class Content(
    val imagePainter: Painter,
    val imageDescription: String,
    val stepDescription: String,
)

@Composable
fun getContent(currentStep: Int): Content {
    return when (currentStep) {
        1 -> Content(
            imagePainter = painterResource(R.drawable.lemon_tree),
            imageDescription = stringResource(R.string.step1alt),
            stepDescription = stringResource(R.string.step1description)
        )

        2 -> Content(
            imagePainter = painterResource(R.drawable.lemon_squeeze),
            imageDescription = stringResource(R.string.step2alt),
            stepDescription = stringResource(R.string.step2description)
        )

        3 -> Content(
            imagePainter = painterResource(R.drawable.lemon_drink),
            imageDescription = stringResource(R.string.step3alt),
            stepDescription = stringResource(R.string.step3description)
        )

        4 -> Content(
            imagePainter = painterResource(R.drawable.lemon_restart),
            imageDescription = stringResource(R.string.step4alt),
            stepDescription = stringResource(R.string.step4description)
        )

        else -> {
            Content(
                imagePainter = painterResource(R.drawable.lemon_tree),
                imageDescription = stringResource(R.string.step1alt),
                stepDescription = stringResource(R.string.step1description)
            )
        }
    }
}

@Composable
fun ContentWrapper(modifier: Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    val content = getContent(currentStep = currentStep)
    squeezeCount = (2..4).random()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (currentStep == 2) {
                    squeezeCount--
                    if (squeezeCount == 0) currentStep++
                } else if (currentStep == 4) {
                    currentStep = 1
                    squeezeCount = 0
                } else {
                    currentStep++
                }
            },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
        ) {
            Image(
                painter = content.imagePainter,
                contentDescription = content.imageDescription,
            )
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = content.stepDescription,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
        )
    }
}
