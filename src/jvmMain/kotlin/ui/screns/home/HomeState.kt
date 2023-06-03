package ui.screns.home

import data.Filter
import data.Note
import data.remote.notesClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object HomeState {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    suspend fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState(loading = true)
            val response = notesClient.request("http://localhost:8080/notes")
            println(response.body() as String)
            _state.value = UiState(notes = response.body())
        }
    }

    fun onFilterClick(filter: Filter) {
        _state.update { it.copy(filter = filter) }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All
    ) {
        val filteredNotes: List<Note>?
            get() = when (filter) {
                Filter.All -> notes
                is Filter.ByType -> notes?.filter { it.type == filter.type }
            }
    }
}