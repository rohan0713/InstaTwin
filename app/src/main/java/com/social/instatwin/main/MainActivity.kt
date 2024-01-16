package com.social.instatwin.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.social.instatwin.data.models.BottomNavItem
import com.social.instatwin.data.models.Result
import com.social.instatwin.navigation.AppNavigation
import com.social.instatwin.network.RetrofitClient
import com.social.instatwin.presentation.BottomNavCompose
import com.social.instatwin.presentation.ExploreCompose
import com.social.instatwin.ui.theme.InstaTwinTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaTwinTheme {
                val navController = rememberNavController()
                val navItems = listOf(
                    BottomNavItem("Home", "home", Icons.Default.Home),
                    BottomNavItem("Explore", "explore", Icons.Default.Search),
                    BottomNavItem("Profile", "profile", Icons.Default.Person)
                )

                Scaffold(bottomBar = {
                    BottomNavCompose(
                        items = navItems,
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        })
                }){
                    AppNavigation(navController = navController)
                }
            }
        }
    }

    suspend fun getResponse(): List<Result> {
        val response = RetrofitClient.api.getCharacter()
        return response.body()?.results!!
    }
}