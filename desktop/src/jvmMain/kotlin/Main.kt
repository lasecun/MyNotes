import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.itram.getAppTitle
import ui.App


fun main() {
    application {
        Window(onCloseRequest = ::exitApplication, title = getAppTitle()) {
            App()
        }
    }
}
