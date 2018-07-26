package javafxx.layouts.scene.canvas

import javafxx.layouts.canvas
import javafxx.layouts.pane
import javafxx.test.PlatformLayoutTest
import kotlin.test.assertEquals

class CanvasTest : PlatformLayoutTest() {

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