package com.neopixl.noteapp.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RewardNavigation(rewardNavController: NavHostController){
    NavHost(rewardNavController, startDestination = RewardDestination.MainReward.route){
        composable(RewardDestination.MainReward.route) {
            RewardMainScreen()
        }
    }
}

@Composable
fun RewardMainScreen() {
    Text("this is the main screen of Rewards")
}