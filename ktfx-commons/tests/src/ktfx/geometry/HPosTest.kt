package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos.BOTTOM_CENTER
import javafx.geometry.Pos.CENTER
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals

class HPosTest {

    private val hpos = HPos.CENTER

    @Test fun plus() {
        assertEquals(hpos + VPos.BOTTOM, BOTTOM_CENTER)
        assertEquals(hpos + VPos.CENTER, CENTER)
    }
}