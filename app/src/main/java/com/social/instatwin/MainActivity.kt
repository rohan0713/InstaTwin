package com.social.instatwin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.social.instatwin.data.Result
import com.social.instatwin.network.RetrofitClient
import com.social.instatwin.ui.theme.InstaTwinTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaTwinTheme {
                // A surface container using the 'background' color from the theme
                val scope = rememberCoroutineScope()
                var list by remember {
                    mutableStateOf<List<Result>>(emptyList())
                }
                LaunchedEffect(null){
                   scope.launch(Dispatchers.Default) {
                       list = getResponse()
                    }
                }
                ExploreCompose(list = list)
            }
        }
    }

    suspend fun getResponse(): List<Result> {
        val response = RetrofitClient.api.getCharacter()
        return response.body()?.results!!
    }
}