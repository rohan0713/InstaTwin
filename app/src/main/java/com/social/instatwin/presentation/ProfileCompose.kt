package com.social.instatwin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.instatwin.R

@Preview
@Composable
fun ProfileCompose() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(0.1f)
                        .clip(RoundedCornerShape(30.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .weight(0.1f)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "10", fontSize = 16.sp, textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Posts", fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(0.1f)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "40", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Followers", fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(0.1f)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "82", fontWeight = FontWeight.Bold,
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Following", fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                text = "FashionInStyle", modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Creating Content",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                fontSize = 14.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier.weight(0.1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Edit Profile")
                }

                Button(
                    onClick = {},
                    modifier = Modifier.weight(0.1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Share Profile")
                }

            }
        }
    }
}