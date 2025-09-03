package com.neopixl.noteapp.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ExploreNavigation(profileNavController: NavHostController) {

    NavHost(
        navController = profileNavController,
        startDestination = ExploreDestination.mainExplore.route
    ) {
        composable(ExploreDestination.mainExplore.route) {
            ExploreMainScreen()
        }
    }
}

@Composable
fun ExploreMainScreen() {
    Text("this is the Explore Main Screen")
}