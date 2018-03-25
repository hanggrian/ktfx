package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos.BOTTOM_CENTER
import javafx.geometry.Pos.CENTER
import javafx.geometry.VPos
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object HPosSpec : Spek({

    given("a horizontal position") {
        val hpos = HPos.CENTER
        it("plus") {
            assertEquals(hpos + VPos.BOTTOM, BOTTOM_CENTER)
            assertEquals(hpos + VPos.CENTER, CENTER)
        }
    }
})