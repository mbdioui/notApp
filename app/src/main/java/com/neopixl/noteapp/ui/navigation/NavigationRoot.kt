package com.neopixl.noteapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.DownhillSkiing
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavTab(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavTab("home_graph", "home", Icons.Default.Home)
    object Session : BottomNavTab("session_graph", "session", Icons.Rounded.DownhillSkiing)
    object Explore : BottomNavTab("explore_graph", "explore", Icons.TwoTone.Star)
    object Groups : BottomNavTab("groups_graph", "groups", Icons.Filled.Group)
    object Rewards : BottomNavTab("rewards_graph", "rewards", Icons.Rounded.Star)
}

sealed class HomeDestinations(val route: String) {
    object HomeMain : HomeDestinations(EnumHomeDestination.MAIN.route)
    object HomeDetail : HomeDestinations(EnumHomeDestination.DETAIL.route)
    object HomeSettings : HomeDestinations(EnumHomeDestination.SETTINGS.route)
}

sealed class SessionsDestination(val route: String) {
    object CreateSession : SessionsDestination(EnumSessionDestination.CREATE_SESSION.route)
    object EditSession : SessionsDestination(EnumSessionDestination.EDIT_SESSION.route)
}

sealed class ExploreDestination(val route: String) {
    object mainExplore : ExploreDestination(EnumExploreDestination.MAIN_EXPLORE.route)
}

sealed class GroupDestination(val route: String) {
    object MainGroup : GroupDestination(EnumGroupDestination.MAIN_GROUP.route)
}

sealed class RewardDestination(val route: String) {
    object MainReward : RewardDestination(EnumRewardDestination.MAIN_REWARD.route)
}


enum class EnumHomeDestination(val route: String) {
    MAIN("home_main"),
    DETAIL("home_detail"),
    SETTINGS("home_settings")
}

enum class EnumSessionDestination(val route: String) {
    CREATE_SESSION("create_session"),
    EDIT_SESSION("edit_session")
}

enum class EnumExploreDestination(val route: String) {
    MAIN_EXPLORE("main_explore")
}

enum class EnumGroupDestination(val route: String) {
    MAIN_GROUP("main_group")
}

enum class EnumRewardDestination(val route: String) {
    MAIN_REWARD("main_reward")
}