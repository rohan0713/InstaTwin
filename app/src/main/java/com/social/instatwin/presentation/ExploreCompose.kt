package com.social.instatwin.presentation

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.social.instatwin.data.models.Result
import com.social.instatwin.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreCompose(list: List<Result>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(120.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
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
        .height(Random.nextInt(200, 200).dp)
        .background(Color.White)){

        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)
    }
}
@Composable
fun getResponse(){
    val scope = rememberCoroutineScope()
    var list by remember {
        mutableStateOf<List<Result>>(emptyList())
    }
    LaunchedEffect(null) {
        scope.launch(Dispatchers.Default) {
            val response = RetrofitClient.api.getCharacter()
            list = response.body()?.results!!
        }
    }
    ExploreCompose(list = list)
}
