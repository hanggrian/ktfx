package ktfx.geometry

import javafx.geometry.Rectangle2D
import org.junit.Test
import kotlin.test.assertEquals

class Rectangle2DTest {

    private val rect = Rectangle2D(10.0, 10.0, 20.0, 20.0)

    @Test fun components() {
        val (minX, minY, width, height, maxX, maxY) = rect
        assertEquals(rect.minX, minX)
        assertEquals(rect.minY, minY)
        assertEquals(rect.width, width)
        assertEquals(rect.height, height)
        assertEquals(rect.maxX, maxX)
        assertEquals(rect.maxY, maxY)
    }
}