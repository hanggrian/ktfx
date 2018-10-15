package ktfx.layouts.scene.layout

import javafx.scene.paint.Color.RED
import ktfx.layouts.pane
import ktfx.layouts.textFlow
import ktfx.test.PlatformLayoutTest
import kotlin.test.assertEquals

class TextFlowTest : PlatformLayoutTest() {

    override fun newInstance() {
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
}