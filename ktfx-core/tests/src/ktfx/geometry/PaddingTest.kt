package ktfx.geometry

import javafx.geometry.Insets
import org.junit.Test
import kotlin.test.assertEquals

class PaddingTest {

    @Test fun static() {
        assertEquals(0.0, 0.0, 0.0, 0.0, Padding.EMPTY)
        assertEquals(1.0, 0.0, 0.0, 0.0, Padding.top(1))
        assertEquals(0.0, 1.0, 0.0, 0.0, Padding.right(1))
        assertEquals(0.0, 0.0, 1.0, 0.0, Padding.bottom(1))
        assertEquals(0.0, 0.0, 0.0, 1.0, Padding.left(1))
    }

    private fun assertEquals(
        expectedTop: Double,
        expectedRight: Double,
        expectedBottom: Double,
        expectedLeft: Double,
        actualPadding: Insets
    ) {
        assertEquals(expectedTop, actualPadding.top)
        assertEquals(expectedRight, actualPadding.right)
        assertEquals(expectedBottom, actualPadding.bottom)
        assertEquals(expectedLeft, actualPadding.left)
    }
}