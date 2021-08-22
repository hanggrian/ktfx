package ktfx.controlsfx.text

import com.hendraanggrian.ktfx.test.initToolkit
import org.controlsfx.glyphfont.FontAwesome
import org.controlsfx.glyphfont.GlyphFontRegistry
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GlyphFontTest {

    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun glyph() {
        val glyphFromChar = FontAwesome() glyph 'A'
        assertEquals("A", glyphFromChar.text)

        val glyphFromString = FontAwesome() glyph "A"
        assertEquals("A", glyphFromString.text)

        val glyphFromEnum = FontAwesome() glyph FontAwesome.Glyph.ADJUST
        assertEquals("\uF042", glyphFromEnum.text)
    }

    @Test
    fun register() {
        val glyphFont = FontAwesome()
        glyphFont.register()
        assertEquals(glyphFont, GlyphFontRegistry.font(glyphFont.name))
    }
}