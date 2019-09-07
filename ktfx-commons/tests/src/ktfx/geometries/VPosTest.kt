package ktfx.geometries

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import kotlin.test.Test
import kotlin.test.assertEquals

class VPosTest {

    @Test fun plus() {
        assertEquals(Pos.TOP_LEFT, VPos.TOP + HPos.LEFT)
        assertEquals(Pos.TOP_CENTER, VPos.TOP + HPos.CENTER)
        assertEquals(Pos.TOP_RIGHT, VPos.TOP + HPos.RIGHT)
        assertEquals(Pos.CENTER_LEFT, VPos.CENTER + HPos.LEFT)
        assertEquals(Pos.CENTER, VPos.CENTER + HPos.CENTER)
        assertEquals(Pos.CENTER_RIGHT, VPos.CENTER + HPos.RIGHT)
        assertEquals(Pos.BOTTOM_LEFT, VPos.BOTTOM + HPos.LEFT)
        assertEquals(Pos.BOTTOM_CENTER, VPos.BOTTOM + HPos.CENTER)
        assertEquals(Pos.BOTTOM_RIGHT, VPos.BOTTOM + HPos.RIGHT)
        assertEquals(Pos.BASELINE_LEFT, VPos.BASELINE + HPos.LEFT)
        assertEquals(Pos.BASELINE_CENTER, VPos.BASELINE + HPos.CENTER)
        assertEquals(Pos.BASELINE_RIGHT, VPos.BASELINE + HPos.RIGHT)
    }
}