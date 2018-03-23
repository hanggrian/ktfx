package ktfx.geometry

import javafx.geometry.Dimension2D
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Dimension2DSpec : Spek({

    given("a 2d dimension") {
        val dimen = Dimension2D(10.0, 20.0)
        it("components") {
            val (width, height) = dimen
            assertEquals(dimen.width, width)
            assertEquals(dimen.height, height)
        }
    }
})