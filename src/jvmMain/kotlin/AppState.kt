import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.concurrent.thread

class AppState {
    var state by mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state = UiState(loading = true)
            getNotes { notes -> state = UiState(notes = notes) }
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}