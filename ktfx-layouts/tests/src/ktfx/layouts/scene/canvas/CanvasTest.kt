package ktfx.layouts.scene.canvas

import javafx.scene.canvas.Canvas
import ktfx.layouts.canvas
import ktfx.layouts.pane
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CanvasTest {

    @Test fun create() {
        val canvas = canvas(10.0, 20.0)
        assertEquals(canvas.width, 10.0)
        assertEquals(canvas.height, 20.0)
    }

    @Test fun layoutManager() {
        assertTrue(pane {
            canvas(10.0, 20.0)
        }.children[0] is Canvas)
    }
}