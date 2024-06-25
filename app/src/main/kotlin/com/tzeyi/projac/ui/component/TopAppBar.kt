package com.tzeyi.projac.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier =
            Modifier
                .fillMaxWidth()
                .height(60.dp),
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
        shadowElevation = 20.dp,
        tonalElevation = 20.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
        ) {
            Column {
                Text("10 Ang Mo Kio Street 65")
                Spacer(modifier.height(4.dp))
                Ett()
            }
        }
    }
}

@Composable
fun Ett(modifier: Modifier = Modifier) {
    Surface(
        color = Color.Red,
        shape = RoundedCornerShape(24.dp),
        modifier = modifier,
    ) {
        Row(
            modifier =
                Modifier.padding(
                    vertical = 2.dp,
                    horizontal = 10.dp,
                ),
        ) {
            Text(
                text = "ETT",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "2 min 4 sec left",
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
    TopBar()
}

@Preview
@Composable
private fun EttPreview() {
    Ett()
}
