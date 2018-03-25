package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.CENTER_RIGHT
import javafx.geometry.VPos
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object VPosSpec : Spek({

    given("a vertical position") {
        val vpos = VPos.CENTER
        it("plus") {
            assertEquals(vpos + HPos.RIGHT, CENTER_RIGHT)
            assertEquals(vpos + HPos.CENTER, CENTER)
        }
    }
})