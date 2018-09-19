package javafxx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals

class HPosTest {

    private val hpos = HPos.CENTER

    @Test fun plus() {
        assertEquals(hpos + VPos.BOTTOM, Pos.BOTTOM_CENTER)
        assertEquals(hpos + VPos.CENTER, Pos.CENTER)
    }
}