package com.neopixl.noteapp.ui.component

import android.R.attr.maxWidth
import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
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
import com.neopixl.noteapp.ui.theme.Purple200


@Composable
fun OffsetBackgroundCard(
    modifier: Modifier = Modifier.padding(top = 8.dp, bottom = 4.dp, start = 7.dp, end = 4.dp),
    backgroundColor: Color = Color.Yellow,
    withOffset: Boolean = true,
    borderColor: Color = MaterialTheme.colorScheme.outlineVariant,
    borderWidth: Dp = 0.7.dp,
    maxWidth: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {
        Text(
            "Sample",
            color = MaterialTheme.colorScheme.onSurface
        )
    }
) {
    val boxWidthModifier = if (maxWidth) Modifier.fillMaxWidth() else Modifier.wrapContentWidth()

    Box(modifier = modifier) {
        // Offset background
        Box(
            modifier = Modifier
                .matchParentSize()
                .then(if (withOffset) Modifier.offset(x = (-6).dp, y = (-6).dp) else Modifier)
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


@Preview(showBackground = true)
@Composable
fun previewOffsetBackgroundCard() {
    NoteAppTheme {
        OffsetBackgroundCard {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                Spacer(Modifier.height(4.dp))
                Text("Sessions", color = MaterialTheme.colorScheme.onSurface)
                Text("19")
            }
        }
    }
}
