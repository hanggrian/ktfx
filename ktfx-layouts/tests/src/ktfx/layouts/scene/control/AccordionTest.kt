package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.layouts.accordion
import ktfx.layouts.label
import ktfx.layouts.pane
import ktfx.test.ToolkitLayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : ToolkitLayoutTest() {

    override fun newInstance() {
        accordion {
            assertEmpty(panes)
            "Hello"()
            "World" {
                label("haha")
            }
            assertEquals(2, panes.size)
            assertTrue(panes[1].content is Label)
        }
    }

    override fun withManager() {
        assertEquals(pane {
            accordion()
        }.children.size, 1)
    }
}