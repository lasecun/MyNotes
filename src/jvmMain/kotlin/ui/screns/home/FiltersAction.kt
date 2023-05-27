package ui.screns.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*

@Composable
fun FilterIcon() {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("All")
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("Texto")
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("Audio")
            }
        }
    }
}