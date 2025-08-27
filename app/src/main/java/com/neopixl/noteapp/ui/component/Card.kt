package com.neopixl.noteapp.ui.component

import android.R.attr.maxWidth
import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.noteapp.ui.theme.NoteAppTheme


@Preview(showBackground = true)
@Composable
fun OffsetBackgroundCard(
    modifier: Modifier = Modifier.padding(top = 8.dp, bottom = 4.dp, start = 7.dp, end = 4.dp),
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = Color.Black,
    borderWidth: Dp = 0.7.dp,
    maxWidth: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = { Text("Sample") }
) {
    val boxWidthModifier = if (maxWidth) Modifier.fillMaxWidth() else Modifier.wrapContentWidth()

    Box(modifier = modifier) {
        // Offset background
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = (-6).dp, y = (-6).dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(true, onClick = onClick)// Offset as needed
                .background(backgroundColor, shape = RoundedCornerShape(16.dp))
        )
        // Foreground content with border
        Box(
            modifier = Modifier
                .then(boxWidthModifier)
                .border(borderWidth, borderColor, RoundedCornerShape(16.dp))
                .background(Color.Transparent, shape = RoundedCornerShape(16.dp))
                .padding(16.dp) // Padding between border and content
        ) {
            // Place your content here
            content()// Example
        }
    }
}


