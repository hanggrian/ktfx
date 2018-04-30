package ktfx.layouts.scene.layout

import javafx.scene.paint.Color.RED
import javafx.scene.text.Text
import ktfx.layouts.LayoutTest
import ktfx.layouts.pane
import ktfx.layouts.textFlow
import kotlin.test.assertEquals

class TextFlowTest : LayoutTest() {

    override fun newInstance() {
        assertEquals(textFlow(Text()).children.size, 1)
    }

    override fun newInstanceInitialized() {
        textFlow {
            "Hello"()
            "World" {
                fill = RED
                assertEquals(fill, RED)
            }

            assertEquals(children.size, 2)
        }
    }

    override fun withManager() {
        assertEquals(pane {
            textFlow()
        }.children.size, 1)
    }

    override fun withManagerInitialized() {
        assertEquals(pane {
            textFlow { }
        }.children.size, 1)
    }
}