package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import kotlin.test.Test
import kotlin.test.assertEquals

class FontTest {

    @Test fun pt() {
        assertEquals(Font.font(18.0), 18.0.pt)
        assertEquals(Font.font(12.0), 12.pt)
    }

    @Test fun fontOf() {
        val font = fontOf("Arial", FontWeight.BOLD, 18.0)
        assertEquals("Arial Bold", font.name)
        assertEquals("Bold", font.style)
        assertEquals(18.0, font.size)
    }

    @Test fun italicFontOf() {
        val font = italicFontOf("Arial", FontWeight.BOLD, 18.0)
        assertEquals("Arial Bold Italic", font.name)
        assertEquals("Bold Italic", font.style)
        assertEquals(18.0, font.size)
    }
}