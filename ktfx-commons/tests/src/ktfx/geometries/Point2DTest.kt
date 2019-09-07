package ktfx.geometries

import javafx.geometry.Point2D
import kotlin.test.Test
import kotlin.test.assertEquals

class Point2DTest {

    private val point = Point2D(10.0, 20.0)

    @Test fun plus() {
        val added = point + Point2D(5.0, 5.0)
        assertEquals(added.x, 15.0)
        assertEquals(added.y, 25.0)
    }

    @Test fun substract() {
        val substracted = point - Point2D(5.0, 5.0)
        assertEquals(substracted.x, 5.0)
        assertEquals(substracted.y, 15.0)
    }
}