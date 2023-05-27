package ui.screns.home

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("My Notes") },
        actions = {
            FilterIcon()
        })
}