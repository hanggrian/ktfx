package ktfx.geometry

import javafx.geometry.HPos.RIGHT
import javafx.geometry.Pos.BOTTOM_RIGHT
import javafx.geometry.VPos.BOTTOM
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object PosSpec : Spek({

    given("a position") {
        val pos = BOTTOM_RIGHT
        it("components") {
            val (vpos, hpos) = pos
            assertEquals(vpos, BOTTOM)
            assertEquals(hpos, RIGHT)
        }
    }
})