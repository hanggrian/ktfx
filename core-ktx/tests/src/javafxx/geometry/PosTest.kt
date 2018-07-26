package javafxx.geometry

import javafx.geometry.HPos.RIGHT
import javafx.geometry.Pos.BOTTOM_RIGHT
import javafx.geometry.VPos.BOTTOM
import org.junit.Test
import kotlin.test.assertEquals

class PosTest {

    private val pos = BOTTOM_RIGHT

    @Test fun components() {
        val (vpos, hpos) = pos
        assertEquals(vpos, BOTTOM)
        assertEquals(hpos, RIGHT)
    }
}