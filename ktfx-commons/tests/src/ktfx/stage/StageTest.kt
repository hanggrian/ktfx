package ktfx.stage

import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertEquals

class StageTest : ToolkitTest {

    @Test fun stage() {
        val stage = stage("Title") {
        }
        assertEquals("Title", stage.title)

    }
}