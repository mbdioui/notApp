package com.neopixl.noteapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun OffsetBackgroundCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFD5B4FF),
    borderColor: Color = Color.Black,
    borderWidth: Dp = 2.dp,
    onClick: () -> Unit = {},
    label: String = "sample"
) {
    Box(modifier = modifier) {
        // Offset background
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = -4.dp, y = -6.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(true, onClick = onClick)// Offset as needed
                .background(backgroundColor, shape = RoundedCornerShape(16.dp))
        )
        // Foreground content with border
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(borderWidth, borderColor, RoundedCornerShape(16.dp))
                .background(Color.Transparent, shape = RoundedCornerShape(16.dp))
                .padding(16.dp) // Padding between border and content
        ) {
            // Place your content here
            Text("$label") // Example
        }
    }
}