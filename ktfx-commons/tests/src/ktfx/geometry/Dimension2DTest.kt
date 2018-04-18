package ktfx.geometry

import javafx.geometry.Dimension2D
import org.junit.Test
import kotlin.test.assertEquals

class Dimension2DTest {

    private val dimen = Dimension2D(10.0, 20.0)

    @Test fun components() {
        val (width, height) = dimen
        assertEquals(dimen.width, width)
        assertEquals(dimen.height, height)
    }
}