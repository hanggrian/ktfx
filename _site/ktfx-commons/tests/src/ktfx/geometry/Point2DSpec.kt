package ktfx.geometry

import javafx.geometry.Point2D
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Point2DSpec : Spek({

    given("a 2d dimension") {
        val point = Point2D(10.0, 20.0)
        it("components") {
            val (x, y) = point
            assertEquals(point.x, x)
            assertEquals(point.y, y)
        }
        it("plus") {
            val added = point + Point2D(5.0, 5.0)
            assertEquals(added.x, 15.0)
            assertEquals(added.y, 25.0)
        }
        it("substract") {
            val substracted = point - Point2D(5.0, 5.0)
            assertEquals(substracted.x, 5.0)
            assertEquals(substracted.y, 15.0)
        }
    }
})