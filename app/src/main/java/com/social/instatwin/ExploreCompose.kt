package com.social.instatwin

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.social.instatwin.data.Result
import kotlin.random.Random


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreCompose(list: List<Result>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(120.dp),
        modifier = Modifier.fillMaxSize().background(Color.Black),
        contentPadding = PaddingValues(5.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
        ){
        items(list){
            ItemContent(item = it)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ItemContent(item: Result){

    val image = rememberImagePainter(data = item.image)
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(Random.nextInt(100, 200).dp)
        .background(Color.White)){

        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)
    }
}
