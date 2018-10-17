package ktfx.stage

import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertEquals

class FileChooserTest : ToolkitTest {

    @Test fun fileChooser() {
        val chooser = fileChooser("Title") {
        }
        assertEquals("Title", chooser.title)
    }
}