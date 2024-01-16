package com.social.instatwin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.instatwin.R

@Preview
@Composable
fun HomeCompose() {

    val items = (1..10).map {
        FeedItem(
            R.drawable.ic_launcher_background,
            200,
            "ufc"
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {

                Text(text = "InstaTwin",
                fontFamily = FontFamily.Serif,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

                    Image(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null)

                    Image(imageVector = Icons.Default.Person,
                        contentDescription = null)
                }
            }

            LazyColumn(content = {
                items(items) { item ->
                    homeItem()
                }
            })

        }
    }
}

data class FeedItem(
    val image: Int,
    val likes: Int,
    val user: String
)

@Preview
@Composable
fun homeItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 20.dp)
            .background(Color.White)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                )

                Text(
                    text = "FashionInStyle",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 5.dp, start = 10.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Icon(
                    imageVector = Icons.Default.Share, contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert, contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                Text(
                    text = "49,670", fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "likes", fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}