package ktfx.scene.paint

import javafx.scene.paint.Color.BLUE
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object ColorSpec : Spek({

    given("an insets") {
        val color = BLUE
        it("components") {
            val (red, green, blue, opacity) = color
            assertEquals(color.red, red)
            assertEquals(color.green, green)
            assertEquals(color.blue, blue)
            assertEquals(color.opacity, opacity)
        }
    }
})