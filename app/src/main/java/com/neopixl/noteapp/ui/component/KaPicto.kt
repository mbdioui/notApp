package com.neopixl.noteapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
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

@Preview
@Composable
fun NumberPicto(
    number: Int = 1,
    borderThick: Dp = 0.7.dp
) {
    NoteAppTheme {
        Box(

        ) {
            Box(
                Modifier
                    .size(45.dp)
                    .align(Alignment.Center)
                    .offset(-3.dp, -3.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surface)

            )
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(16.dp))
                    .border(borderThick, Color.Black, RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = "$number",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}