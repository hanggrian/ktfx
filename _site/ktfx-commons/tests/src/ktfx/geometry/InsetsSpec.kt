package ktfx.geometry

import javafx.geometry.Insets
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object InsetsSpec : Spek({

    given("an insets") {
        val insets = Insets(10.0, 20.0, 30.0, 40.0)
        it("components") {
            val (top, right, bottom, left) = insets
            assertEquals(insets.top, top)
            assertEquals(insets.right, right)
            assertEquals(insets.bottom, bottom)
            assertEquals(insets.left, left)
        }
    }
})