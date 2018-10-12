package ktfx.geometry

import org.junit.Test
import kotlin.test.assertEquals

class InsetsTest {

    private val insets = Padding(10, 20, 30, 40)

    @Test fun components() {
        val (top, right, bottom, left) = insets
        assertEquals(insets.top, top)
        assertEquals(insets.right, right)
        assertEquals(insets.bottom, bottom)
        assertEquals(insets.left, left)
    }
}