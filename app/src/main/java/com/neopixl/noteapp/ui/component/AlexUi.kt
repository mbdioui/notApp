package com.neopixl.noteapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.noteapp.ui.theme.NoteAppTheme

@Composable
fun MohamedUI() {
    Box(
        modifier = Modifier
            .testTag("Box principal container 1")
            .width(380.dp)
            .height(200.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .testTag("Box fond rosé")
                .width(350.dp)
                .height(150.dp)
                .offset(x = -5.dp, y = -5.dp)
                .background(
                    color = Color.Green.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center)

        )
        Box(
            modifier = Modifier
                .testTag("Box blanche contour")
                .width(350.dp)
                .height(150.dp)

                .background(color = Color.White, shape = RoundedCornerShape(24.dp))
                .border(
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    shape = RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .testTag("Box intérieure rosé noir")
                    .padding(bottom = 5.dp, end = 5.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Transparent, shape = RoundedCornerShape(24.dp))
                    .align(Alignment.TopStart)
            ) {

                Column(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f)
                            .background(Color.Green.copy(0.5f)),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                /*  CircleButton(
                                      size = 38,
                                      buttonColor = Color.Black,
                                      contentPadding = 12,
                                      content = {
                                          GenericIconVector(
                                              icon = Rate,
                                              tint = AppTheme.colors.white
                                          )
                                      }) {

                                  }*/

                                Column(modifier = Modifier.padding(start = 16.dp)) {
                                    Text(
                                        text = "Session name",
                                        color = Color.Black,
                                        style = MaterialTheme.typography.bodyLarge
                                    )

                                    Text(
                                        text = "THROW",
                                        color = Color.Red,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.padding(top = 0.dp)
                                    )
                                }
                            }

                            Row(
                                Modifier.wrapContentHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = "60'",
                                    color = Color.Black,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .background(Color.Black),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(modifier = Modifier.size(20.dp)) {
                                    /*GenericIconVector(
                                        icon = Rate,
                                        tint = AppTheme.colors.white
                                    )*/
                                }

                                Text(
                                    text = "Friday 19/08",
                                    color = Color.LightGray,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                            }

                            Row(
                                Modifier.wrapContentHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {

                                Box(modifier = Modifier.size(20.dp)) {
                                    /*GenericIconVector(
                                        icon = Rate,
                                        tint = AppTheme.colors.white
                                    )*/
                                }
                                Text(
                                    text = "10h30",
                                    color = Color.LightGray,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                            }

                        }

                    }
                }
            }
        }

    }
}

//@Composable
//fun CircleButton(
//    size: Int,
//    buttonColor: Color.Black,
//    contentPadding: Int,
//    content: () -> GenericIconVector,
//    content: @Composable () -> Unit
//) {
//    TODO("Not yet implemented")
//}


@Preview
@Composable
fun MohamedUIPreview() {
    NoteAppTheme {
        MohamedUI()
    }
}