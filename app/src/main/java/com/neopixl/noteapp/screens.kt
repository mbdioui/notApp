package com.neopixl.noteapp

// Fichier: Screens.kt

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(onNavigateToDetail: () -> Unit) {
    Column {
        Text("Écran Principal")
        Button({ onNavigateToDetail() }) { Text("detail navigation") }
    }
}

@Composable
fun SessionsScreen(onNavigateToCreate: () -> Unit) {
    Text("Écran des Sessions")
}

@Composable
fun ExploreScreen() {
    Text("Écran d'Exploration")
}

@Composable
fun GroupsScreen() {
    Text("Écran des Groupes")
}

@Composable
fun RewardsScreen() {
    Text("Écran des Récompenses")
}

@Preview
@Composable
fun PreviewScreens() {
    HomeScreen(onNavigateToDetail = {})
}

@Composable
fun HomeDetailScreen(onBack: () -> Boolean) {
    Column {
        Text("this is the detail Screen")
        Button({ onBack() }) { Text("Go back") }
    }
}