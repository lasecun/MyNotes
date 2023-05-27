package data

import data.Note.*
import kotlinx.coroutines.flow.flow

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type {
        TEXT, AUDIO
    }
}

suspend fun getNotes() = flow {
    val notes = (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
    emit(notes)
}
