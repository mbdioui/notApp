package com.neopixl.noteapp

import android.R.attr.thickness
import android.net.http.SslCertificate.saveState
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.neopixl.noteapp.ui.navigation.BottomNavTab
import com.neopixl.noteapp.ui.navigation.MainNavHost
import com.neopixl.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
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
        val navController = rememberNavController()

        // État pour la tab sélectionnée
        var selectedTabRoute by rememberSaveable { mutableStateOf(BottomNavTab.Session.route) }

        NoteAppTheme {
            Scaffold(
                topBar = {
                    AppTopBar(
                        navController = navController,
                        currentTabRoute = selectedTabRoute
                    )
                },
                bottomBar = {
                    Column {  HorizontalDivider(
                        color = Color.Black,
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    AppBottomBar(
                        selectedTabRoute = selectedTabRoute,
                        onTabSelected = { tabRoute ->
                            selectedTabRoute = tabRoute
                            // Naviguer vers la route de l'onglet sans ajouter à la backstack
                            navController.navigate(tabRoute) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }}
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    MainNavHost(
                        navController = navController
                    )
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
    navController: NavHostController,
    currentTabRoute: String
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Déterminer si on peut revenir en arrière
    val canGoBack = navController.previousBackStackEntry != null

    CenterAlignedTopAppBar(
        title = {
            // Titre optionnel selon la tab ou la destination
        },
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (canGoBack) {
                    IconButton(onClick = { navController.popBackStack() }) {
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