package com.social.instatwin.presentation

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.social.instatwin.R
import com.social.instatwin.data.models.Post
import com.social.instatwin.data.models.Result
import com.social.instatwin.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun HomeCompose(list : List<Result>) {

    var items by remember {
        mutableStateOf<List<Post>>(emptyList())
    }

    items = getFeed()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "InstaTwin",
                    fontFamily = FontFamily.Serif,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

                    Image(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null
                    )

                    Image(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_placeholder),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )

                LazyRow(content = {
                    items(list) { item ->
                        StoryItem(item.image)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                })

            }

            LazyColumn(content = {
                items(items) { item ->
                    homeItem(item.username, item.postImg, item.likes.toString())
                }
            }, modifier = Modifier.padding(top = 10.dp, bottom = 80.dp))

        }
    }
}

data class FeedItem(
    val image: Int,
    val likes: Int,
    val user: String
)

@OptIn(ExperimentalCoilApi::class)
@Composable
fun homeItem(user: String, img : String, likes : String) {

    val image = rememberImagePainter(data = img)
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
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = user,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 5.dp, start = 10.dp),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = image,
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
                    text = likes, fontSize = 15.sp,
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

@OptIn(ExperimentalCoilApi::class)
@Composable
fun StoryItem(url : String) {

    val image = rememberImagePainter(data = url)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .size(65.dp)
            .border(2.dp, Color.DarkGray, shape = CircleShape)
            .padding(6.dp)
            .clip(CircleShape)
    )
}

@Composable
fun getStories(){
    val scope = rememberCoroutineScope()
    var list by remember {
        mutableStateOf<List<Result>>(emptyList())
    }
    LaunchedEffect(null) {
        scope.launch(Dispatchers.IO) {
            val response = RetrofitClient.api.getCharacter()
            list = response.body()?.results!!
        }
    }
    HomeCompose(list = list)
}

@Composable
fun getFeed() : List<Post> {

    var list by remember {
        mutableStateOf<List<Post>>(emptyList())
    }
    val scope = CoroutineScope(Dispatchers.IO)
    LaunchedEffect(key1 = null) {
        scope.launch {
            val response = RetrofitClient.feed.getFeed()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    list = response.body()?.posts!!
                }
            }
        }
    }
    println(list)
    return list
}