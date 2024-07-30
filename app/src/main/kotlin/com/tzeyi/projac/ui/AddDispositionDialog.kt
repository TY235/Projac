package com.tzeyi.projac.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ListItem(
    val id: Int,
    val name: String,
)

@Composable
fun SearchableSelectableList() {
    var searchQuery by remember { mutableStateOf("") }
    val items =
        remember {
            listOf(
                ListItem(1, "Arrest"),
                ListItem(2, "Assist"),
                ListItem(3, "Cancel"),
                ListItem(4, "Citation"),
                ListItem(5, "Closed"),
                ListItem(6, "Duplicate"),
                ListItem(7, "False"),
                ListItem(8, "GOA"),
                ListItem(9, "Hangup"),
                ListItem(10, "Nuisance"),
            )
        }

    var selectedItems by rememberSaveable { mutableStateOf(setOf<ListItem>()) }

    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            placeholder = { Text("Search") },
        )

        LazyColumn {
            items(items.filter { it.name.contains(searchQuery, ignoreCase = true) }) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(
                        checked = selectedItems.contains(item),
                        onCheckedChange = { isChecked ->
                            selectedItems =
                                if (isChecked) {
                                    selectedItems + item
                                } else {
                                    selectedItems - item
                                }
                        },
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(item.name)
                }
            }
        }

        // Display selected items (for demonstration)
        Text(
            text = "Selected: ${selectedItems.joinToString(", ") { it.name }}",
            modifier = Modifier.padding(16.dp),
        )
    }
}
