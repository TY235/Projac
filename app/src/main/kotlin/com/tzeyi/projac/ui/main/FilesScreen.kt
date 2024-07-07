package com.tzeyi.projac.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.tzeyi.projac.R

@Composable
fun FilesScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            repeat(10) {
                items(it) {
                    FileItem()
                }
            }
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(horizontal = 16.dp, vertical = 20.dp)
                    .zIndex(3f),
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add media")
        }
    }
}

@Composable
fun FileItem(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors =
            CardDefaults
                .cardColors()
                .copy(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                ),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 60.dp),
                // Adjust padding to avoid overlap with the time text
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier =
                        Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp)),
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "<fileName>",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "<description>",
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                }
            }

            Text(
                text = "12:30",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier =
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
            )
        }
    }
}

@Preview
@Composable
private fun FilesScreenPreview() {
    FilesScreen()
}

@Preview
@Composable
private fun FileItemPreview() {
    FileItem()
}
