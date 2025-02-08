package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardAppTheme {
                BusinessCard(
                    name = "< Leona Ilao />",
                    title = "Web Developer",
                    phoneNumber = "587-968-2462",
                    socialHandle = "@Leona.I",
                    email = "leona@outlook.com"
                )
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    socialHandle: String,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = stringResource(id = R.string.background_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = name,
                fontSize = 35.sp,
                color = Color.White
            )
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(120.dp))

            ContactCard(
                icon = Icons.Default.Phone,
                text = phoneNumber,
                backgroundColor = Color(0xFF7D3C98)
            )

            Spacer(modifier = Modifier.height(12.dp))

            ContactCard(
                icon = Icons.Default.Person,
                text = socialHandle,
                backgroundColor = Color(0xFF7D3C98)
            )

            Spacer(modifier = Modifier.height(12.dp))

            ContactCard(
                icon = Icons.Default.Email,
                text = email,
                backgroundColor = Color(0xFF7D3C98)
            )
        }
    }
}

@Composable
fun ContactCard(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, backgroundColor: Color) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .height(35.dp)
            .clip(CutCornerShape(5.dp))
            .background(backgroundColor)
            .padding(horizontal = 5.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            name = "Leona Ilao",
            title = "Web Developer",
            phoneNumber = "587-968-2462",
            socialHandle = "@Leona.I",
            email = "leona@outlook.com"
        )
    }
}
