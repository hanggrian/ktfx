package ktfx.scene.text

import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import org.junit.Test
import kotlin.test.assertEquals

class FontTest {

    @Test fun buildFont() {
        assertEquals("Bold", Font.font(null, FontWeight.BOLD, 12.0).style)

        assertEquals("Bold", buildFont { it weight bold }.style)
        assertEquals("Italic", buildFont { it posture italic }.style)
        assertEquals(16.0, buildFont { it size 16 }.size)
    }
}