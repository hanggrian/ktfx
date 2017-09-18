package kotfx.dialogs

import javafx.stage.Window
import kotfx.JavaFXThreadingRule
import org.junit.Rule

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class DialogsTest {

    @get:Rule
    val rule = JavaFXThreadingRule()

    // @Test
    fun alert() {
        alert("")
        alert("") {}

        alert("", "")
        alert("", "") {}
    }

    // @Test
    fun dialog() {

    }

    // @Test
    fun chooser(window: Window) {
        fileChooser().showSaveDialog(window)
        fileChooser("Hello world!").showOpenDialog(window)
    }
}