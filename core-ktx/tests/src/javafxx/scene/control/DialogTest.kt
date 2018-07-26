package javafxx.scene.control

import javafx.scene.control.Dialog
import javafx.stage.Stage
import javafxx.test.AppTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DialogTest : AppTest() {

    lateinit var dialog: Dialog<String>

    override fun start(stage: Stage) {
        dialog = dialog("Title") {
        }
    }

    @Test fun custom() {
        assertNotNull(dialog)
    }

    @Test fun withTitle() {
        assertEquals(dialog.title, "Title")
    }
}