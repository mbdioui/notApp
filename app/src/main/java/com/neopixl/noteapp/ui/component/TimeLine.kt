package com.neopixl.noteapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.noteapp.data.DataStore
import com.neopixl.noteapp.domain.models.Step
import com.neopixl.noteapp.ui.theme.NoteAppTheme

@Preview
@Composable
fun TimeLinePreview() {
    NoteAppTheme {
        TimeLine()
    }
}

@Composable
fun TimeLine(
    steps: List<Step> = DataStore.stepSamples
) {
    Column {
        steps.forEachIndexed { index, step ->
            TimelineStep(
                step.order,
                step.title,
                step.description,
                index == 0,
                index == steps.size - 1
            )
        }
    }
}

@Composable
fun TimelineStep(
    number: Int,
    title: String,
    description: String,
    isFirst: Boolean,
    isLast: Boolean
) {
    Row(verticalAlignment = Alignment.Top) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(50.dp)
                .padding(vertical = 2.dp)


        ) {
            // Draw line above except for the first step
            if (!isFirst) {
                VerticalTinyLine(3) // Tiny line above step indicator
                Spacer(Modifier.height(8.dp))
            }
            // Step "square"
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
            ) {
                NumberPicto(number)
            }
            // Draw line below except for the last step
            if (!isLast) {
                VerticalTinyLine(3) // Tiny line above step indicator
            }
        }
        Spacer(Modifier.width(12.dp))
        // Padding applied calculated by adding VerticalLines height(3*3+4) +spacer(8) + offsetbox(3)
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top, modifier =
                Modifier.padding(top = if (isFirst) 0.dp else 24.dp)
        ) {

            Text(title.uppercase(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(
                description,
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 21.sp
            )
        }
    }
}

@Composable
fun VerticalTinyLine(
    segmentCount: Int = 6,
    segmentWidth: Dp = 1.dp,
    segmentHeight: Dp = 3.dp,
    lineColor: Color = Color.Black,
    segmentSpacing: Dp = 4.dp
) {
    Column(
        modifier = Modifier.width(segmentWidth),
        verticalArrangement = Arrangement.spacedBy(segmentSpacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(segmentCount) {
            Box(
                modifier = Modifier
                    .width(segmentWidth)
                    .height(segmentHeight)
                    .background(lineColor)
            )
        }
    }
}