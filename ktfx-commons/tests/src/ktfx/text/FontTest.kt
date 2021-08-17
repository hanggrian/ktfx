package ktfx.text

import javafx.scene.text.Font
import kotlin.test.Test
import kotlin.test.assertEquals

class FontTest {

    @Test
    fun pt() {
        assertEquals(Font.font(12.0), 12.pt)
        assertEquals(Font.font(18.0), 18.0.pt)
    }

    @Test
    fun fontOf() {
        val font1 = fontOf("Arial", size = 12)
        assertEquals("Arial", font1.family)
        assertEquals(12.0, font1.size)
        val font2 = fontOf("Arial", size = 18.0)
        assertEquals("Arial", font2.family)
        assertEquals(18.0, font2.size)
    }
}
