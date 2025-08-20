package com.neopixl.noteapp.ui.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.noteapp.ui.theme.NoteAppTheme


@OptIn(ExperimentalLayoutApi::class)
@Preview(showSystemUi = false)
@Composable
fun GroupCard(
    iconTint: Color = MaterialTheme.colorScheme.outline,
    tags: List<String> = listOf("Tag1", "Tag3", "Tag4", "Tag11", "Tag33", "Tag44"),
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val scrollableTagState = rememberScrollState()
    val animatedShadowOffsetY by animateDpAsState(
        targetValue = if (!expanded) 0.dp else 4.dp,
        animationSpec = tween(durationMillis = 300),
        label = "ShadowOffsetYAnimation"
    )
    val expandedCardShadowOffsetY by animateDpAsState(
        targetValue = if (expanded) 4.dp else 0.dp, // Shadow for expanded card appears with it
        animationSpec = tween(durationMillis = 300),
        label = "ExpandedCardShadowOffsetYAnimation"
    )
    NoteAppTheme() {
        Column(
            Modifier
//                .background(MaterialTheme.colorScheme.tertiary)
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .offset(y = animatedShadowOffsetY)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Black)
                )
                CoreGroup(
                    iconTint,
                    scrollableTagState,
                    tags,
                    expanded,
                    { newState -> expanded = newState }
                )
            }
            if (!expanded)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = expandedCardShadowOffsetY)
                        .padding(16.dp),
                    /*colors = CardDefaults.outlinedCardColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = Black,
                    ),*/
                    shape = RoundedCornerShape(bottomEnd = 4.dp, bottomStart = 4.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(4) {
                            Text(
                                "RUN",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                                    .padding(horizontal = 18.dp, vertical = 12.dp)
                            )
                        }
                    }
                }
        }
    }
}


@Composable
private fun CoreGroup(
    iconTint: Color,
    scrollableTagState: ScrollState,
    tags: List<String>,
    expanded: Boolean,
    onIconClick: (Boolean) -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.White,
            contentColor = Black,
            disabledContentColor = Black,
            disabledContainerColor = Black
        ),
        border = BorderStroke(2.dp, Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DescriptionRow(iconTint)
            TagRow(
                scrollableTagState,
                tags,
                iconTint,
                expanded,
                { newState -> onIconClick(newState) })
        }
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun TagRow(
    scrollableTagState: ScrollState,
    tags: List<String>,
    iconTint: Color,
    expanded: Boolean,
    onIconClick: (Boolean) -> Unit = { !expanded }
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            maxLines = 1,
            overflow = FlowRowOverflow.Clip,
            modifier = Modifier
                .horizontalScroll(
                    scrollableTagState
                )
                .weight(7f)
        ) {
            for (tag in tags) {
                Tag(label = tag)
            }
        }
        Box(
            Modifier
                .size(45.dp)
                .weight(0.75f)

        ) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .border(
                        width = 1.dp, color = iconTint, shape = CircleShape
                    )
                    .rotate(if (expanded) 180f else 0f)
                    .clip(CircleShape)
                    .clickable(true, onClick = { onIconClick(!expanded) }),
                tint = iconTint,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun DescriptionRow(iconTint: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Face,
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
        )
        Text("Club ASH Baby athlé", modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = iconTint
        )
    }
}


@Preview
@Composable
fun Tag(
    modifier: Modifier = Modifier,
    label: String = "sample"
) {
    NoteAppTheme {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(
                    shape = RoundedCornerShape(15.dp), color = MaterialTheme.colorScheme.background
                )
                .padding(horizontal = 16.dp)
                .then(modifier),
        ) {
            Text(label)
        }
    }
}