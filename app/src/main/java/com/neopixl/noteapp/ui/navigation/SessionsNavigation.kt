package com.neopixl.noteapp.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SessionsNavigation(searchNavController: NavHostController) {

    NavHost(
        navController = searchNavController,
        startDestination = SessionsDestination.CreateSession.route
    ) {
        composable(SessionsDestination.CreateSession.route) {
            SearchMainScreen(
                onNavigateToResults = { query ->
                    searchNavController.navigate("${SessionsDestination.EditSession.route}/$query")
                }
            )
        }

        composable("${SessionsDestination.EditSession.route}/{query}") { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            SearchResultsScreen(
                query = query,
                onBack = {
                    searchNavController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun SearchResultsScreen(query: String, onBack: () -> Boolean) {
    Column {
        Text("this is the Search Result Screen with query $query")
        Button({ onBack() }) { Text("go back") }
    }
}

@Composable
fun SearchMainScreen(onNavigateToResults: (String) -> Unit) {
    Column {
        Text("this is the main Search Screen")
        Button({ onNavigateToResults("test_query") }) { Text(("navigate to results")) }
    }
}