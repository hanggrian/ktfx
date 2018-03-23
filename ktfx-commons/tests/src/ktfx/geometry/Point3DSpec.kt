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
    }
})