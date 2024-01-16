package com.social.instatwin.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.social.instatwin.data.models.BottomNavItem

@Composable
fun BottomNavCompose(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        containerColor = NavigationBarDefaults.containerColor,
        tonalElevation = NavigationBarDefaults.Elevation

    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(selected = selected, onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray
                ),
                icon = {
                    Column(modifier = Modifier.wrapContentSize(), horizontalAlignment = CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = null)
                        Text(text = item.title, textAlign = TextAlign.Center, fontSize = 10.sp)
                    }
            })
        }
    }
}