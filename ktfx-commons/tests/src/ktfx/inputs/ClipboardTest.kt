package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat
import javafx.stage.Stage
import ktfx.isFxThread
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClipboardTest : ApplicationTest() {
    private lateinit var clipboard: Clipboard

    override fun start(stage: Stage) {
        assertTrue(isFxThread(), "A")
        clipboard = Clipboard.getSystemClipboard()
    }

    @Test fun test() {
        interact {
            assertTrue(isFxThread(), "B")
            clipboard[DataFormat.PLAIN_TEXT] = "Hello world"
            assertTrue(isFxThread(), "C")
            assertTrue(DataFormat.PLAIN_TEXT in clipboard)
            assertEquals("Hello world", clipboard[DataFormat.PLAIN_TEXT])
        }
    }
}
