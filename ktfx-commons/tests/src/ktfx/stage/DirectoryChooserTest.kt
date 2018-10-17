package ktfx.stage

import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertEquals

class DirectoryChooserTest : ToolkitTest {

    @Test fun directoryChooser() {
        val chooser = directoryChooser("Title") {
        }
        assertEquals("Title", chooser.title)
    }
}