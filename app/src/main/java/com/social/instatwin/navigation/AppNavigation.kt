package com.social.instatwin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.social.instatwin.presentation.ExploreCompose
import com.social.instatwin.presentation.HomeCompose
import com.social.instatwin.presentation.ProfileCompose
import com.social.instatwin.presentation.getResponse
import com.social.instatwin.presentation.getStories

@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            getStories()
        }

        composable("explore"){
            getResponse()
        }

        composable("profile"){
            ProfileCompose()
        }
    }
}