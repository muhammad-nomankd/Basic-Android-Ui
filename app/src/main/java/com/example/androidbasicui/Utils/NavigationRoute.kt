package com.example.androidbasicui.Utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidbasicui.ui.screen.FavoriteScree
import com.example.androidbasicui.ui.screen.HomeScreen
import com.example.androidbasicui.ui.screen.ProfileScreen
import com.example.androidbasicui.ui.screen.SettingScreen

@Composable
fun NavigationRoute(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.rout) {
        composable(Screen.Home.rout) { HomeScreen() }
        composable(Screen.Setting.rout) { SettingScreen() }
        composable(Screen.Profile.rout) { ProfileScreen() }
        composable(Screen.Favorite.rout) { FavoriteScree() }
    }
}
