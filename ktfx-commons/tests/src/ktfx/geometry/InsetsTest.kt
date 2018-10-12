package ktfx.geometry

import javafx.geometry.Insets
import org.junit.Test
import kotlin.test.assertEquals

class InsetsTest {

    private val padding = Insets(10.0, 20.0, 30.0, 40.0)

    @Test fun components() {
        val (top, right, bottom, left) = padding
        assertEquals(padding.top, top)
        assertEquals(padding.right, right)
        assertEquals(padding.bottom, bottom)
        assertEquals(padding.left, left)
    }
}