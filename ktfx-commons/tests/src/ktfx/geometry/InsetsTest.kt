package ktfx.geometry

import org.junit.Test
import kotlin.test.assertEquals

class InsetsTest {

    private val padding = Padding(10, 20, 30, 40)

    @Test fun components() {
        val (top, right, bottom, left) = padding
        assertEquals(padding.top, top)
        assertEquals(padding.right, right)
        assertEquals(padding.bottom, bottom)
        assertEquals(padding.left, left)
    }
}