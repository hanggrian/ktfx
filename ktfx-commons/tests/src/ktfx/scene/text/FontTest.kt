package ktfx.scene.text

import org.junit.Test
import kotlin.test.assertEquals

class FontTest {

    @Test fun buildFont() {
        assertEquals("Bold Italic", buildFont { it + bold + italic }.style)
        assertEquals("Arial", buildFont { it + "Arial" }.family)
        assertEquals(16.0, buildFont { it + 16 }.size)
    }
}