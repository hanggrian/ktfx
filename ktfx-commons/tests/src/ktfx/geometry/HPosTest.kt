package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals

class HPosTest {

    @Test fun plus() {
        assertEquals(Pos.TOP_LEFT, HPos.LEFT + VPos.TOP)
        assertEquals(Pos.TOP_CENTER, HPos.CENTER + VPos.TOP)
        assertEquals(Pos.TOP_RIGHT, HPos.RIGHT + VPos.TOP)
        assertEquals(Pos.CENTER_LEFT, HPos.LEFT + VPos.CENTER)
        assertEquals(Pos.CENTER, HPos.CENTER + VPos.CENTER)
        assertEquals(Pos.CENTER_RIGHT, HPos.RIGHT + VPos.CENTER)
        assertEquals(Pos.BOTTOM_LEFT, HPos.LEFT + VPos.BOTTOM)
        assertEquals(Pos.BOTTOM_CENTER, HPos.CENTER + VPos.BOTTOM)
        assertEquals(Pos.BOTTOM_RIGHT, HPos.RIGHT + VPos.BOTTOM)
        assertEquals(Pos.BASELINE_LEFT, HPos.LEFT + VPos.BASELINE)
        assertEquals(Pos.BASELINE_CENTER, HPos.CENTER + VPos.BASELINE)
        assertEquals(Pos.BASELINE_RIGHT, HPos.RIGHT + VPos.BASELINE)
    }
}