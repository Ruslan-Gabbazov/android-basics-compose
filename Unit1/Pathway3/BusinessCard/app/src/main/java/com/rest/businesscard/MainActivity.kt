package com.rest.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.rest.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard() {
    PersonDescriptionCard()
    ContactsCard()
}


@Composable
fun PersonDescriptionCard() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xffd2e8d4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = stringResource(R.string.full_name),
            color = Color(0xFF073042),
            fontSize = 36.sp,
            lineHeight = 42.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.skill_description),
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight(700)
        )
    }
}


@Composable
fun ContactsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        DividerLine()
        ContactDetailsRow(
            image = painterResource(id = R.drawable.ic_phone),
            text = stringResource(R.string.phone_number),
        )
        DividerLine()
        ContactDetailsRow(
            image = painterResource(id = R.drawable.ic_share),
            text = stringResource(R.string.share_name),
        )
        DividerLine()
        ContactDetailsRow(
            image = painterResource(id = R.drawable.ic_email),
            text = stringResource(R.string.email),
        )
        DividerLine()
    }
}


@Composable
fun ContactDetailsRow(image: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp)
    ) {
        Image(painter = image, contentDescription = text, modifier = Modifier.padding(8.dp))
        Text(
            text = text,
            color = Color(0xFF073042),
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun DividerLine() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0xFF073042)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}