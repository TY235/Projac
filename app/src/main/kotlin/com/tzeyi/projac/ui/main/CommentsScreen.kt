package com.tzeyi.projac.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tzeyi.projac.ui.theme.ProjacTheme

@Composable
fun CommentsScreen() {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            repeat(10) {
                items(it) {
                    CommentItem(modifier = Modifier)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        HorizontalDivider(
            color = DividerDefaults.color.copy(alpha = 0.3f),
            thickness = 2.dp,
        )
        SendCommentBar(onSend = {})
    }
}

@Composable
fun CommentItem(modifier: Modifier = Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(horizontal = 10.dp, vertical = 6.dp),
    ) {
        Text(
            text = "Admin1",
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = "Assigned: FRC13.",
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = "2 Apr, 12:38",
            fontSize = 9.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun SendCommentBar(
    onSend: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 15.dp, horizontal = 10.dp),
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Enter text") },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onSend) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 9.dp),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    modifier = Modifier.size(17.dp),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Send")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CommentsScreenPreview() {
    ProjacTheme {
        CommentsScreen()
    }
}

@Preview
@Composable
private fun CommentItemPreview() {
    CommentItem()
}

@Preview
@Composable
private fun SendCommentBarPreview() {
    SendCommentBar({})
}
