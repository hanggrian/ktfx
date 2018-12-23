package ktfx.geometries

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PosTest {

    @Test fun components() {
        assertComponents(VPos.TOP, HPos.LEFT, Pos.TOP_LEFT)
        assertComponents(VPos.TOP, HPos.CENTER, Pos.TOP_CENTER)
        assertComponents(VPos.TOP, HPos.RIGHT, Pos.TOP_RIGHT)
        assertComponents(VPos.CENTER, HPos.LEFT, Pos.CENTER_LEFT)
        assertComponents(VPos.CENTER, HPos.CENTER, Pos.CENTER)
        assertComponents(VPos.CENTER, HPos.RIGHT, Pos.CENTER_RIGHT)
        assertComponents(VPos.BOTTOM, HPos.LEFT, Pos.BOTTOM_LEFT)
        assertComponents(VPos.BOTTOM, HPos.CENTER, Pos.BOTTOM_CENTER)
        assertComponents(VPos.BOTTOM, HPos.RIGHT, Pos.BOTTOM_RIGHT)
        assertComponents(VPos.BASELINE, HPos.LEFT, Pos.BASELINE_LEFT)
        assertComponents(VPos.BASELINE, HPos.CENTER, Pos.BASELINE_CENTER)
        assertComponents(VPos.BASELINE, HPos.RIGHT, Pos.BASELINE_RIGHT)
    }

    @Test fun contains() {
        assertContains(VPos.TOP, HPos.LEFT, Pos.TOP_LEFT)
        assertContains(VPos.TOP, HPos.CENTER, Pos.TOP_CENTER)
        assertContains(VPos.TOP, HPos.RIGHT, Pos.TOP_RIGHT)
        assertContains(VPos.CENTER, HPos.LEFT, Pos.CENTER_LEFT)
        assertContains(VPos.CENTER, HPos.CENTER, Pos.CENTER)
        assertContains(VPos.CENTER, HPos.RIGHT, Pos.CENTER_RIGHT)
        assertContains(VPos.BOTTOM, HPos.LEFT, Pos.BOTTOM_LEFT)
        assertContains(VPos.BOTTOM, HPos.CENTER, Pos.BOTTOM_CENTER)
        assertContains(VPos.BOTTOM, HPos.RIGHT, Pos.BOTTOM_RIGHT)
        assertContains(VPos.BASELINE, HPos.LEFT, Pos.BASELINE_LEFT)
        assertContains(VPos.BASELINE, HPos.CENTER, Pos.BASELINE_CENTER)
        assertContains(VPos.BASELINE, HPos.RIGHT, Pos.BASELINE_RIGHT)
    }

    private fun assertComponents(
        expectedVPos: VPos,
        expectedHPos: HPos,
        actualPos: Pos
    ) = actualPos.let {
        assertEquals(expectedVPos, it.vpos)
        assertEquals(expectedHPos, it.hpos)
    }

    private fun assertContains(
        expectedVPos: VPos,
        expectedHPos: HPos,
        actualPos: Pos
    ) {
        assertTrue(expectedVPos in actualPos)
        assertTrue(expectedHPos in actualPos)
    }
}