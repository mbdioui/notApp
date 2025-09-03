package com.neopixl.noteapp.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavigation(modifier: Modifier = Modifier, homeNavController: NavHostController) {

    NavHost(startDestination = HomeDestinations.HomeMain.route, navController = homeNavController) {
        composable(HomeDestinations.HomeMain.route) {
            HomeMainScreen(onNavigateToDetail = {
                homeNavController.navigate(HomeDestinations.HomeDetail.route)
            }, onNavigateToSettings = {
                homeNavController.navigate(HomeDestinations.HomeSettings.route)
            })
        }

        composable(HomeDestinations.HomeDetail.route) {
            HomeDetailScreen(
                onBack = {
                    homeNavController.popBackStack()
                })
        }

        composable(HomeDestinations.HomeSettings.route) {
            HomeSettingsScreen(
                onBack = {
                    homeNavController.popBackStack()
                })
        }
    }
}

@Composable
fun HomeSettingsScreen(onBack: () -> Boolean) {
    Column {
        Text("this is Home Settings Screen")
        Button({ onBack() }) { Text("onBack") }
    }
}

@Composable
fun HomeDetailScreen(onBack: () -> Boolean) {
    Column {
        Text("this is the Home Detail Screen")
        Button({ onBack() }) { Text("onBack") }
    }
}

@Composable
fun HomeMainScreen(onNavigateToDetail: () -> Unit, onNavigateToSettings: () -> Unit) {
    Column {
        Text("this is the main Screen Home")
        Button(
            onClick = { onNavigateToDetail() }) { Text("onNavigateToDetail") }
        Button(
            onClick = { onNavigateToSettings() }) {
            Text("onNavigateToSettings")
        }
    }
}