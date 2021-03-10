package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat
import io.github.hendraanggrian.ktfx.test.FxThreadRule
import org.junit.Rule
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClipboardTest {
    @Rule @JvmField var rule = FxThreadRule()
    private lateinit var clipboard: Clipboard

    @BeforeTest fun start() {
        clipboard = Clipboard.getSystemClipboard()
    }

    @Test fun test() {
        clipboard[DataFormat.PLAIN_TEXT] = "Hello world"
        assertTrue(DataFormat.PLAIN_TEXT in clipboard)
        assertEquals("Hello world", clipboard[DataFormat.PLAIN_TEXT])
    }
}
