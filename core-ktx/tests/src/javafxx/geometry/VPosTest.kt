package javafxx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.CENTER_RIGHT
import javafx.geometry.VPos
import org.junit.Test
import kotlin.test.assertEquals

class VPosTest {

    private val vpos = VPos.CENTER

    @Test fun plus() {
        assertEquals(vpos + HPos.RIGHT, CENTER_RIGHT)
        assertEquals(vpos + HPos.CENTER, CENTER)
    }
}