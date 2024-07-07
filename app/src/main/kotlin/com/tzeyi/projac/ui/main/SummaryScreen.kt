package com.tzeyi.projac.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tzeyi.projac.ui.theme.ProjacTheme

@Composable
fun SummaryScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
        Modifier.fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = "20240402-0002",
            onValueChange = {},
            label = { Text("Incident Number") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = "8",
                onValueChange = {},
                label = { Text("Priority") },
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(
                value = "1",
                onValueChange = {},
                label = { Text("Alarm") },
                modifier = Modifier.weight(1f),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = "PBURG",
            onValueChange = {},
            label = { Text("Incident Type") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(15.dp))
        SectionHeader(sectionHeader = "Incident Location")
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            ) {
            OutlinedTextField(
                value = "10 Ang Mo Kio Street 65",
                onValueChange = {},
                label = { Text("Location") },
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Locate incident location",
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Share location",
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = "Techpoint",
            onValueChange = {},
            label = { Text("Common Place") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = " ",
                onValueChange = {},
                label = { Text("Unit") },
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(
                value = " ",
                onValueChange = {},
                label = { Text("Floor") },
                modifier = Modifier.weight(1f),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = "Singapore",
                onValueChange = {},
                label = { Text("City") },
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(
                value = " ",
                onValueChange = {},
                label = { Text("State") },
                modifier = Modifier.weight(1f),
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        SectionHeader(sectionHeader = "Caller Info")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = " ",
            onValueChange = {},
            label = { Text("Caller") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = " ",
            onValueChange = {},
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = " ",
            onValueChange = {},
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun SectionHeader(
    sectionHeader: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier =
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp)),
    ) {
        Text(
            text = sectionHeader,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
private fun SummaryScreenPreview() {
    ProjacTheme {
        Surface {
            SummaryScreen()
        }
    }
}

@Preview
@Composable
private fun SectionHeaderPreview() {
    SectionHeader("Incident Location")
}
