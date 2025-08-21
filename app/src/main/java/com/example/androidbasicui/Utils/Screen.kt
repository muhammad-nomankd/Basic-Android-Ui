package com.example.androidbasicui.Utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val rout: String,val title: String,val icon: ImageVector) {
    object Home: Screen("home","Home", Icons.Default.Home)
    object Setting: Screen("setting","Setting", Icons.Default.Settings)
    object Profile: Screen("profile","Profile", Icons.Default.Person)
    object Favorite: Screen("favorite","Favorite", Icons.Default.Favorite)
}