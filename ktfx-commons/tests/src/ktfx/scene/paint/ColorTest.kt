package ktfx.scene.paint

import javafx.scene.paint.Color.BLUE
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {

    private val color = BLUE

    @Test fun components() {
        val (red, green, blue, opacity) = color
        assertEquals(color.red, red)
        assertEquals(color.green, green)
        assertEquals(color.blue, blue)
        assertEquals(color.opacity, opacity)
    }

    @Test fun webFormat() = assertEquals(color.webFormat, "#0000FF")
}