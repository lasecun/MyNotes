package ui

import androidx.compose.runtime.*
import ui.screns.detail.Detail
import ui.screns.home.Home

sealed interface Route {
    object Home : Route
    data class Detail(val id: Long) : Route
}

@Composable
fun App() {

    var route by remember { mutableStateOf<Route>(Route.Home) }

    route.let {
        when (it) {
            Route.Home -> Home(onCreateClick = { route = Route.Detail(-1) })
            is Route.Detail -> Detail(it.id, onClose = { route = Route.Home })
        }
    }
}

