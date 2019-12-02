package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat
import javafx.stage.Stage
import ktfx.test.AppTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClipboardTest : AppTest() {
    private lateinit var clipboard: Clipboard

    override fun start(stage: Stage) {
        clipboard = Clipboard.getSystemClipboard()
    }

    @Test fun test() {
        interact {
            clipboard[DataFormat.PLAIN_TEXT] = "Hello world"
            assertTrue(DataFormat.PLAIN_TEXT in clipboard)
            assertEquals("Hello world", clipboard[DataFormat.PLAIN_TEXT])
        }
    }
}