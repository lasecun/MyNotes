package ui.screns.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.itram.getAppTitle
import com.itram.getPlatformName
import data.Filter
import data.Note

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    TopAppBar(
        title = { Text(getAppTitle()) },
        actions = {
            FilterIcon(onFilterClick)
        })
}

@Composable
fun FilterIcon(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listOf(
                Filter.All to "All",
                Filter.ByType(Note.Type.TEXT) to "Text",
                Filter.ByType(Note.Type.AUDIO) to "Audio"
            ).forEach { (filter, label) ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onFilterClick(filter)
                }) {
                    Text(label)
                }
            }
        }
    }
}