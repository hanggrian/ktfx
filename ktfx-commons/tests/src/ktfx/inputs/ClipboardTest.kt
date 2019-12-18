package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat
import javafx.stage.Stage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@ExtendWith(ApplicationExtension::class)
class ClipboardTest {
    private lateinit var clipboard: Clipboard

    @Start fun start(stage: Stage) {
        clipboard = Clipboard.getSystemClipboard()
    }

    @Test fun FxRobot.test() {
        interact {
            clipboard[DataFormat.PLAIN_TEXT] = "Hello world"
            assertTrue(DataFormat.PLAIN_TEXT in clipboard)
            assertEquals("Hello world", clipboard[DataFormat.PLAIN_TEXT])
        }
    }
}
