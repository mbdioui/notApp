package com.neopixl.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.noteapp.ui.component.GroupCard
import com.neopixl.noteapp.ui.component.OffsetBackgroundCard
import com.neopixl.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                val names = listOf("hello", "buddy")
                Scaffold { innerPadding ->
                    Column(
                        Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(9.dp),
                            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            items(items = names) { currentName ->
                                OffsetBackgroundCard()
                            }
                        }
                        GroupCard()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        val names = listOf("Sample one ", "Sample Two")
        LazyColumn(
            Modifier.padding(60.dp),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = names) { currentName ->
                OffsetBackgroundCard(withOffset = true)
            }
        }
    }
}