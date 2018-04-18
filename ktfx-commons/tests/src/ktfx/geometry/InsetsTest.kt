package ktfx.geometry

import javafx.geometry.Insets
import org.junit.Test
import kotlin.test.assertEquals

class InsetsTest {

    private val insets = Insets(10.0, 20.0, 30.0, 40.0)

    @Test fun components() {
        val (top, right, bottom, left) = insets
        assertEquals(insets.top, top)
        assertEquals(insets.right, right)
        assertEquals(insets.bottom, bottom)
        assertEquals(insets.left, left)
    }
}