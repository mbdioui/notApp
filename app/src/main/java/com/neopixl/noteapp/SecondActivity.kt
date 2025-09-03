package com.neopixl.noteapp

import GroupNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.neopixl.noteapp.ui.navigation.BottomNavTab
import com.neopixl.noteapp.ui.navigation.HomeDestinations
import com.neopixl.noteapp.ui.navigation.HomeNavigation
import com.neopixl.noteapp.ui.navigation.ExploreNavigation
import com.neopixl.noteapp.ui.navigation.RewardNavigation
import com.neopixl.noteapp.ui.navigation.SessionsDestination
import com.neopixl.noteapp.ui.navigation.SessionsNavigation
import com.neopixl.noteapp.ui.theme.NoteAppTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainComposable()
        }
    }

    @Preview
    @Composable
    private fun MainComposable() {
        // NavControllers pour chaque tab - créés une seule fois
        val homeNavController = rememberNavController()
        val sessionNavController = rememberNavController()
        val exploreNavController = rememberNavController()
        val groupNavController = rememberNavController()
        val rewardNavController = rememberNavController()

        // État pour la tab sélectionnée (sauvé sous forme de String)
        var selectedTabRoute by rememberSaveable { mutableStateOf(BottomNavTab.Home.route) }

        NoteAppTheme {
            Scaffold(
                topBar = {
                    AppTopBar(
                        currentTabRoute = selectedTabRoute,
                        homeNavController = homeNavController,
                        sessionNavController = sessionNavController,
                    )
                },
                bottomBar = {
                    AppBottomBar(
                        selectedTabRoute = selectedTabRoute,
                        onTabSelected = { tabRoute -> selectedTabRoute = tabRoute }
                    )
                }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    // Afficher le NavHost correspondant à la tab sélectionnée
                    when (selectedTabRoute) {
                        BottomNavTab.Home.route -> {
                            HomeNavigation(homeNavController = homeNavController)
                        }

                        BottomNavTab.Session.route -> {
                            SessionsNavigation(searchNavController = sessionNavController)
                        }

                        BottomNavTab.Explore.route -> {
                            ExploreNavigation(profileNavController = exploreNavController)
                        }

                        BottomNavTab.Groups.route ->{
                            GroupNavigation(groupNavController = groupNavController)
                        }

                        BottomNavTab.Rewards.route ->{
                            RewardNavigation(rewardNavController = rewardNavController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AppBottomBar(
    selectedTabRoute: String,
    onTabSelected: (String) -> Unit
) {
    val bottomNavTabs = listOf(
        BottomNavTab.Home,
        BottomNavTab.Session,
        BottomNavTab.Explore,
        BottomNavTab.Groups,
        BottomNavTab.Rewards
    )

    NavigationBar {
        bottomNavTabs.forEach { tab ->
            NavigationBarItem(
                selected = selectedTabRoute == tab.route,
                onClick = { onTabSelected(tab.route) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.title
                    )
                },
                label = {
                    Text(text = tab.title)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar(
    currentTabRoute: String,
    homeNavController: NavHostController,
    sessionNavController: NavHostController,
) {
    // Observer les états de navigation de chaque tab
    val homeBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val sessionBackStackEntry by sessionNavController.currentBackStackEntryAsState()

    // Déterminer si on peut revenir en arrière selon la tab active
    val canGoBack = when (currentTabRoute) {
        BottomNavTab.Home.route -> {
            val homeCurrentRoute = homeBackStackEntry?.destination?.route
            homeCurrentRoute != null && homeCurrentRoute != HomeDestinations.HomeMain.route
        }

        BottomNavTab.Session.route -> {
            val searchCurrentRoute = sessionBackStackEntry?.destination?.route
            searchCurrentRoute != null && searchCurrentRoute != SessionsDestination.CreateSession.route
        }

        BottomNavTab.Explore.route -> {
            // Ajoutez votre logique pour Profile ici si nécessaire
            false
        }

        else -> false
    }

    CenterAlignedTopAppBar(
        title = {
            // Optionnel: afficher le titre selon la tab ou laisser vide
            // when (currentTabRoute) {
            //     BottomNavTab.Home.route -> Text("Accueil")
            //     BottomNavTab.Search.route -> Text("Recherche")
            //     BottomNavTab.Profile.route -> Text("Profil")
            // }
        },
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (canGoBack) {
                    IconButton(onClick = {
                        // Appeler popBackStack sur le bon NavController
                        when (currentTabRoute) {
                            BottomNavTab.Home.route -> homeNavController.popBackStack()
                            BottomNavTab.Session.route -> sessionNavController.popBackStack()
                            BottomNavTab.Explore.route -> Unit
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                }
                Icon(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo de l'app",
                    modifier = Modifier.padding(8.dp),
                    tint = Color.Unspecified
                )
            }
        },
        actions = {
            // Icône de notification
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color.Black,
                modifier = Modifier
                    .size(30.dp)
                    .border(BorderStroke(1.dp, Color.Black), CircleShape)
                    .padding(2.dp)
            )
            // Icône de profil
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Profil",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(2.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewAppBar() {
    NoteAppTheme(dynamicColor = false) {
        AppTopBar(
            currentTabRoute = BottomNavTab.Home.route,
            homeNavController = rememberNavController(),
            sessionNavController = rememberNavController()
        )
    }
}
