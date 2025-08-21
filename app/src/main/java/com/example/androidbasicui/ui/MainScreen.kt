package com.example.androidbasicui.ui

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidbasicui.Utils.NavigationRoute
import com.example.androidbasicui.Utils.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedDrawerItem by rememberSaveable { mutableIntStateOf(0) }
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    val navItems = listOf(
        Screen.Home, Screen.Favorite, Screen.Setting, Screen.Profile
    )


    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        /* gesturesEnabled = TODO(),
         scrimColor = TODO(),*/
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(280.dp)) {
                Text(
                    "App Explorer",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(top = 24.dp, start = 24.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Navigation and Discover",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = 24.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                DrawerSectionHeader("Main Section")
                NavigationDrawerItem(
                    label = { Text("Home Feed") },
                    selected = selectedDrawerItem == 0,
                    onClick = {
                        selectedDrawerItem = 0
                        scope.launch { drawerState.close() }
                    },
                    icon = {
                        if (selectedDrawerItem == 0) Icon(
                            Icons.Filled.Home, contentDescription = "Home Feed"
                        ) else Icon(Icons.Outlined.Home, contentDescription = "Home Feed")
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer)
                )
                NavigationDrawerItem(
                    label = { Text("Categories") },
                    selected = selectedDrawerItem == 1,
                    onClick = {
                        selectedDrawerItem = 1
                        scope.launch { drawerState.close() }
                    },
                    icon = {
                        if (selectedDrawerItem == 1) Icon(
                            Icons.Filled.List, contentDescription = "Categories"
                        ) else Icon(Icons.Outlined.List, contentDescription = "Categories")
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer)
                )
                DrawerSectionHeader("User Area")
                NavigationDrawerItem(
                    label = { Text("Profile") },
                    selected = selectedDrawerItem == 2,
                    onClick = {
                        selectedDrawerItem = 2
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    icon = {
                        if (selectedDrawerItem == 2) Icon(
                            Icons.Filled.Person, contentDescription = "profile"
                        ) else Icon(Icons.Outlined.Person, contentDescription = "Profile")
                    })
                NavigationDrawerItem(
                    label = { Text("Favorite") },
                    selected = selectedDrawerItem == 3,
                    onClick = {
                        selectedDrawerItem = 3
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    icon = {
                        if (selectedDrawerItem == 3) Icon(
                            Icons.Filled.Favorite, contentDescription = "profile"
                        ) else Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Profile")
                    })

                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))

                NavigationDrawerItem(
                    label = { Text("Setting") },
                    selected = selectedDrawerItem == 4,
                    onClick = {
                        selectedDrawerItem = 4
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    icon = {
                        if (selectedDrawerItem == 4) Icon(
                            Icons.Filled.Settings, contentDescription = "setting"
                        ) else Icon(Icons.Outlined.Settings, contentDescription = "setting")
                    }


                )
                NavigationDrawerItem(
                    label = { Text("About App") },
                    selected = selectedDrawerItem == 5,
                    onClick = { selectedDrawerItem = 5; scope.launch { drawerState.close() } },
                    icon = {
                        if (selectedDrawerItem == 5) Icon(
                            Icons.Filled.Info, contentDescription = "About App"
                        ) else Icon(
                            Icons.Outlined.Info, contentDescription = "info"
                        )
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = MaterialTheme.colorScheme.primaryContainer)
                )

            }
        },


        ) {
        Scaffold(topBar = {
            TopAppBar(title = { Text("Android Basic Ui") }, navigationIcon = {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            })
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add new item action */ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }, bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainer) {
                navItems.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.rout,
                        onClick = {
                            navController.navigate(screen.rout) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) })
                }
            }
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                NavigationRoute(navController)
            }

        }

    }
}