package ui.screns.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import data.Note

@Composable
@Preview
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit) {

    MaterialTheme {
        Scaffold(
            topBar = { TopBar(onFilterClick = vm::onFilterClick) },
            floatingActionButton = {
                FloatingActionButton(onClick = { onNoteClick(Note.NEW_NOTE) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) { padding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                if (vm.state.loading) {
                    CircularProgressIndicator()
                }
                vm.state.filteredNotes?.let {notes->
                    NotesList(
                        notes = notes,
                        onNoteClick = { onNoteClick(it.id) }
                    )
                }
            }
        }
    }
}