package com.tzeyi.projac.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CancelCreationDialog(
    onDismissRequest: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        icon = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error,
            )
        },
        title = { Text("Cancel Incident Creation") },
        text = { Text("Are you sure you want to cancel creating this new incident?") },
        confirmButton = {
            Button(
                onClick = onConfirmClick,
                colors =
                    ButtonDefaults
                        .buttonColors()
                        .copy(
                            containerColor = MaterialTheme.colorScheme.error,
                            contentColor = MaterialTheme.colorScheme.onError,
                        ),
            ) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Resume")
            }
        },
    )
}

@Preview
@Composable
private fun CancelCreationDialogPreview() {
    CancelCreationDialog({}, {})
}
