package com.neopixl.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.noteapp.ui.component.OffsetBackgroundCard
import com.neopixl.noteapp.ui.theme.NoteAppTheme

class SecondActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
        NoteAppTheme {
            val names = listOf("hello", "buddy")
            Scaffold(topBar = { KaTopBar() }, bottomBar = { KaBottomBar() }) { innerPadding ->
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(9.dp),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    items(items = names) { currentName ->
                        OffsetBackgroundCard(withOffset = true)
                    }
                }
            }
        }
    }
}

@Composable
fun KaBottomBar() {
    BottomAppBar(
        containerColor = Color.White, contentPadding = PaddingValues(4.dp)
    ) {

    }
}

@Preview
@Composable
fun BottomBarPreview() {
    NoteAppTheme {
        KaBottomBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewAppBar() {
    NoteAppTheme(dynamicColor = false) {
        KaTopBar()
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun KaTopBar() {
    TopAppBar(
        title = { /* Optional: Text("Screen Title") or leave empty */ },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.logo),
                modifier = Modifier.padding(8.dp),
                contentDescription = "App Logo", // Good practice for accessibility
                tint = Color.Unspecified // Correctly keeps your logo's original colors
            )
        },
        actions = {
            // Notification Icon
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications", // For accessibility
                tint = Color.Black,
                modifier = Modifier
                    .size(30.dp)
                    .border(border = BorderStroke(1.dp, Color.Black), CircleShape)
                    .padding(2.dp)
            )
            // Profile Icon
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Profile", // For accessibility
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(2.dp)
            )
        })
}
