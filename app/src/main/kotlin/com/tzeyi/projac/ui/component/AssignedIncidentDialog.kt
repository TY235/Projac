package com.tzeyi.projac.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tzeyi.projac.R

data class NewIncident(
    val incidentNo: String,
    val incidentType: String,
    val priority: Int,
    val alarm: Int,
    val location: String,
)

@Composable
fun AssignedIncidentDialog(
    onDismiss: () -> Unit,
    newIncident: NewIncident,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties =
            DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_assignment_outline),
                    contentDescription = "New incident icon",
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "New Incident Assigned",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.height(20.dp))
                OutlinedTextField(
                    label = { Text("Incident No.") },
                    value = newIncident.incidentNo,
                    onValueChange = {},
                )
                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text("Incident Type") },
                    value = newIncident.incidentType,
                    onValueChange = {},
                )
                Spacer(Modifier.height(10.dp))
                Row {
                    OutlinedTextField(
                        label = { Text("Priority") },
                        value = newIncident.priority.toString(),
                        onValueChange = {},
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(Modifier.width(10.dp))
                    OutlinedTextField(
                        label = { Text("Alarm") },
                        value = newIncident.alarm.toString(),
                        onValueChange = {},
                        modifier = Modifier.weight(1f),
                    )
                }
                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text("Location") },
                    value = newIncident.location,
                    onValueChange = {},
                )
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Acknowledge")
                }
            }
        }
    }
}

@Preview
@Composable
private fun AssignedIncidentDialogPreview() {
    AssignedIncidentDialog(
        {},
        NewIncident(
            "20240402-0002",
            "PBURG",
            8,
            1,
            "10 Ang Mo Kio Street 65",
        ),
    )
}
