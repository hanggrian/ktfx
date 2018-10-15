package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.layouts.accordion
import ktfx.layouts.label
import ktfx.layouts.pane
import ktfx.test.PlatformLayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : PlatformLayoutTest() {

    override fun newInstance() {
        accordion {
            "Hello"()
            "World" {
                label("haha")
            }

            assertEquals(panes.size, 2)
            assertTrue(panes[1].content is Label)
        }
    }

    override fun withManager() {
        assertEquals(pane {
            accordion()
        }.children.size, 1)
    }
}