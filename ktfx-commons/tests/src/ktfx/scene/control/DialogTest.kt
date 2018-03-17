package ktfx.scene.control

import javafx.scene.control.Dialog
import javafx.stage.Stage
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DialogTest : ApplicationTest() {

    lateinit var dialog: Dialog<String>

    override fun start(stage: Stage?) {
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