package ui

import androidx.compose.runtime.*
import ui.screns.detail.Detail
import ui.screns.detail.DetailViewModel
import ui.screns.home.Home
import ui.screns.home.HomeViewModel

sealed interface Route {
    object Home : Route
    data class Detail(val id: Long) : Route
}

@Composable
fun App() {

    var route by remember { mutableStateOf<Route>(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            Route.Home -> Home(
                vm = HomeViewModel(scope),
                onNoteClick = { noteId -> route = Route.Detail(noteId) }
            )
            is Route.Detail -> Detail(
                vm = DetailViewModel(scope, it.id),
                onClose = { route = Route.Home }
            )
        }
    }
}

