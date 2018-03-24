package ktfx.geometry

import javafx.geometry.Point3D
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Point3DSpec : Spek({

    given("a 2d dimension") {
        val point = Point3D(10.0, 20.0, 30.0)
        it("components") {
            val (x, y, z) = point
            assertEquals(point.x, x)
            assertEquals(point.y, y)
            assertEquals(point.z, z)
        }
        it("plus") {
            val added = point + Point3D(5.0, 5.0, 5.0)
            assertEquals(added.x, 15.0)
            assertEquals(added.y, 25.0)
            assertEquals(added.z, 35.0)
        }
        it("substract") {
            val substracted = point - Point3D(5.0, 5.0, 5.0)
            assertEquals(substracted.x, 5.0)
            assertEquals(substracted.y, 15.0)
            assertEquals(substracted.z, 25.0)
        }
        it("times") {
            val timed = point * 2.0
            assertEquals(timed.x, 20.0)
            assertEquals(timed.y, 40.0)
            assertEquals(timed.z, 60.0)
        }
    }
})