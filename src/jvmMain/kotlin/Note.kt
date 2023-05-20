import Note.*

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type {
        TEXT, AUDIO
    }
}

fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    val notes = (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
    callback(notes)
}
