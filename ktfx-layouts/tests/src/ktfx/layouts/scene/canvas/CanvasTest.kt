package ktfx.layouts.scene.canvas

import ktfx.layouts.LayoutTest
import ktfx.layouts.canvas
import ktfx.layouts.pane
import kotlin.test.assertEquals

class CanvasTest : LayoutTest() {

    override fun newInstance() {
        val canvas = canvas(10.0, 20.0)
        assertEquals(canvas.width, 10.0)
        assertEquals(canvas.height, 20.0)
    }

    override fun newInstanceInitialized() {
        canvas {

        }
    }

    override fun withManager() {
        assertEquals(pane {
            canvas()
        }.children.size, 1)
    }

    override fun withManagerInitialized() {
        assertEquals(pane {
            canvas { }
        }.children.size, 1)
    }
}