package javafxx.layouts.scene.control

import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import javafxx.layouts.accordion
import javafxx.layouts.label
import javafxx.layouts.pane
import javafxx.test.PlatformLayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AccordionTest : PlatformLayoutTest() {

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