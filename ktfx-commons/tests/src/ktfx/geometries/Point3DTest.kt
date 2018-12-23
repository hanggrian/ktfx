package ktfx.geometries

import javafx.geometry.Point3D
import org.junit.Test
import kotlin.test.assertEquals

class Point3DTest {

    private val point = Point3D(10.0, 20.0, 30.0)

    @Test fun plus() {
        val added = point + Point3D(5.0, 5.0, 5.0)
        assertEquals(added.x, 15.0)
        assertEquals(added.y, 25.0)
        assertEquals(added.z, 35.0)
    }

    @Test fun substract() {
        val substracted = point - Point3D(5.0, 5.0, 5.0)
        assertEquals(substracted.x, 5.0)
        assertEquals(substracted.y, 15.0)
        assertEquals(substracted.z, 25.0)
    }

    @Test fun times() {
        val timed = point * 2.0
        assertEquals(timed.x, 20.0)
        assertEquals(timed.y, 40.0)
        assertEquals(timed.z, 60.0)
    }
}