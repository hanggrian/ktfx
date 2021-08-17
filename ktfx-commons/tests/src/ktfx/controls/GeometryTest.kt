package ktfx.controls

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.Side
import javafx.geometry.VPos
import kotlin.test.Test
import kotlin.test.assertSame

class GeometryTest {

    @Test
    fun pos() {
        assertSame(Pos.TOP_LEFT, TOP_LEFT)
        assertSame(Pos.TOP_CENTER, TOP)
        assertSame(Pos.TOP_RIGHT, TOP_RIGHT)
        assertSame(Pos.CENTER_LEFT, LEFT)
        assertSame(Pos.CENTER, CENTER)
        assertSame(Pos.CENTER_RIGHT, RIGHT)
        assertSame(Pos.BOTTOM_LEFT, BOTTOM_LEFT)
        assertSame(Pos.BOTTOM_CENTER, BOTTOM)
        assertSame(Pos.BOTTOM_RIGHT, BOTTOM_RIGHT)
        assertSame(Pos.BASELINE_LEFT, BASELINE_LEFT)
        assertSame(Pos.BASELINE_CENTER, BASELINE)
        assertSame(Pos.BASELINE_RIGHT, BASELINE_RIGHT)
    }

    @Test
    fun hpos() {
        assertSame(HPos.LEFT, H_LEFT)
        assertSame(HPos.CENTER, H_CENTER)
        assertSame(HPos.RIGHT, H_RIGHT)
    }

    @Test
    fun vpos() {
        assertSame(VPos.TOP, V_TOP)
        assertSame(VPos.CENTER, V_CENTER)
        assertSame(VPos.BOTTOM, V_BOTTOM)
        assertSame(VPos.BASELINE, V_BASELINE)
    }

    @Test
    fun orientation() {
        assertSame(Orientation.HORIZONTAL, HORIZONTAL)
        assertSame(Orientation.VERTICAL, VERTICAL)
    }

    @Test
    fun side() {
        assertSame(Side.TOP, SIDE_TOP)
        assertSame(Side.BOTTOM, SIDE_BOTTOM)
        assertSame(Side.LEFT, SIDE_LEFT)
        assertSame(Side.RIGHT, SIDE_RIGHT)
    }
}