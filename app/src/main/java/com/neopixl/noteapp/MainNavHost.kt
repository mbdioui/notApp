// Nouveau fichier: MainNavHost.kt
package com.neopixl.noteapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.neopixl.noteapp.ExploreScreen
import com.neopixl.noteapp.GroupsScreen
import com.neopixl.noteapp.HomeDetailScreen
import com.neopixl.noteapp.HomeScreen
import com.neopixl.noteapp.RewardsScreen
import com.neopixl.noteapp.SessionsScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    selectedTabRoute: String,
    onTabSelected: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavTab.Home.route,
        route = HomeDestinations.HomeMain.route
    ) {
        // Navigation pour l'onglet Home
        navigation(
            startDestination = HomeDestinations.HomeMain.route,
            route = BottomNavTab.Home.route
        ) {
            composable(HomeDestinations.HomeMain.route) {
                HomeScreen(
                    onNavigateToDetail = { navController.navigate(HomeDestinations.HomeDetail.route) }
                )
            }
            composable(HomeDestinations.HomeDetail.route) {
                HomeDetailScreen({ navController.popBackStack() })
            }
            // Ajouter d'autres destinations home ici
        }

        // Navigation pour l'onglet Session
        navigation(
            startDestination = SessionsDestination.CreateSession.route,
            route = BottomNavTab.Session.route
        ) {
            composable(SessionsDestination.CreateSession.route) {
                SessionsScreen(
                    onNavigateToCreate = { /* navigation vers création */ }
                )
            }
            // Ajouter d'autres destinations session ici
        }

        // Navigation pour l'onglet Explore
        navigation(
            startDestination = ExploreDestination.mainExplore.route,
            route = BottomNavTab.Explore.route
        ) {
            composable(ExploreDestination.mainExplore.route) {
                ExploreScreen()
            }
            // Ajouter d'autres destinations explore ici
        }

        // Navigation pour l'onglet Groups
        navigation(
            startDestination = GroupDestination.MainGroup.route,
            route = BottomNavTab.Groups.route
        ) {
            composable(GroupDestination.MainGroup.route) {
                GroupsScreen()
            }
            // Ajouter d'autres destinations groups ici
        }

        // Navigation pour l'onglet Rewards
        navigation(
            startDestination = RewardDestination.MainReward.route,
            route = BottomNavTab.Rewards.route
        ) {
            composable(RewardDestination.MainReward.route) {
                RewardsScreen()
            }
            // Ajouter d'autres destinations rewards ici
        }
    }
}