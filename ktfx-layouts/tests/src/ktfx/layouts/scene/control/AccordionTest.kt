package ktfx.layouts.scene.control

import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.accordion
import ktfx.layouts.label
import ktfx.layouts.pane
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : LayoutTest() {

    override fun newInstance() {
        assertEquals(accordion(TitledPane()).panes.size, 1)
    }

    override fun newInstanceInitialized() {
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

    override fun withManagerInitialized() {
        assertEquals(pane {
            accordion { }
        }.children.size, 1)
    }
}