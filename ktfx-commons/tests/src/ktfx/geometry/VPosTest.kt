package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals

class VPosTest {

    private val vpos = VPos.CENTER

    @Test fun plus() {
        assertEquals(vpos + HPos.RIGHT, Pos.CENTER_RIGHT)
        assertEquals(vpos + HPos.CENTER, Pos.CENTER)
    }
}