package com.neopixl.noteapp.ui.component

import android.graphics.Rect
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.noteapp.ui.theme.NoteAppTheme

@Preview
@Composable
fun HighlightedText(
    text: String = "Home",
    modifier: Modifier = Modifier
) {
    NoteAppTheme {
        var textSize by remember { mutableStateOf(IntSize.Zero) }
        Box {
            Box(
                modifier = Modifier
                    .offset(
                        y = (textSize.height * .055f).dp
                    )
                    .size(
                        width = with(LocalDensity.current) { textSize.width.toDp() },
                        height = with(LocalDensity.current) { textSize.height.toDp() * .85f } // adjust height as needed
                    )
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.BottomCenter)
                    .then(modifier)
            )
            Box {
                Text(
                    text.uppercase(),
                    fontSize = 43.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .onGloballyPositioned { coordinates ->
                            textSize = coordinates.size
                        }
                )
            }
        }
    }
}