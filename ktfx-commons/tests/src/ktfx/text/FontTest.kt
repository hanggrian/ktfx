package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FontTest {

    @Test fun pt() {
        assertEquals(Font.font(18.0), 18.0.pt)
        assertEquals(Font.font(12.0), 12.pt)
    }

    @Test fun plus() {
        val boldArial = FontWeight.BOLD + "Arial"
        assertTrue("Bold" in boldArial.name)
        assertTrue("Arial" in boldArial.name)
        val boldItalic = FontWeight.BOLD + FontPosture.ITALIC
        assertTrue("Bold" in boldItalic.name)
        assertTrue("Italic" in boldItalic.name)
        val bold16 = FontWeight.BOLD + 16.0
        assertTrue("Bold" in bold16.name)
        assertEquals(16.0, bold16.size)
        val bold18 = FontWeight.BOLD + 18
        assertTrue("Bold" in bold18.name)
        assertEquals(18.0, bold18.size)

        val italicArial = FontPosture.ITALIC + "Arial"
        assertTrue("Italic" in italicArial.name)
        assertTrue("Arial" in italicArial.name)
        val italicBold = FontPosture.ITALIC + FontWeight.BOLD
        assertTrue("Italic" in italicBold.name)
        assertTrue("Bold" in italicBold.name)
        val italic16 = FontPosture.ITALIC + 16.0
        assertTrue("Italic" in italic16.name)
        assertEquals(16.0, italic16.size)
        val italic18 = FontPosture.ITALIC + 18
        assertTrue("Italic" in italic18.name)
        assertEquals(18.0, italic18.size)

        val doubleArial = 16.0 + "Arial"
        assertEquals(16.0, doubleArial.size)
        assertTrue("Arial" in doubleArial.name)
        val doubleBold = 16.0 + FontWeight.BOLD
        assertEquals(16.0, doubleBold.size)
        assertTrue("Bold" in doubleBold.name)
        val doubleItalic = 16.0 + FontPosture.ITALIC
        assertEquals(16.0, doubleItalic.size)
        assertTrue("Italic" in doubleItalic.name)

        val intArial = 18 + "Arial"
        assertEquals(18.0, intArial.size)
        assertTrue("Arial" in intArial.name)
        val intBold = 18 + FontWeight.BOLD
        assertEquals(18.0, intBold.size)
        assertTrue("Bold" in intBold.name)
        val intItalic = 18 + FontPosture.ITALIC
        assertEquals(18.0, intItalic.size)
        assertTrue("Italic" in intItalic.name)

        val system = Font.getDefault()
        val arialBoldItalic21 = system + "Arial" + FontWeight.BOLD + FontPosture.ITALIC + 21.0
        assertTrue("Arial" in arialBoldItalic21.name)
        assertTrue("Bold" in arialBoldItalic21.name)
        assertTrue("Italic" in arialBoldItalic21.name)
        assertEquals(21.0, arialBoldItalic21.size)
        val arialBoldItalic24 = system + "Arial" + FontWeight.BOLD + FontPosture.ITALIC + 24
        assertTrue("Arial" in arialBoldItalic24.name)
        assertTrue("Bold" in arialBoldItalic24.name)
        assertTrue("Italic" in arialBoldItalic24.name)
        assertEquals(24.0, arialBoldItalic24.size)
    }

    @Test fun internal() {
        assertEquals(FontWeight.BOLD, (FontWeight.BOLD + 14).weight)
        assertEquals(FontPosture.ITALIC, (FontPosture.ITALIC + 14).posture)
    }
}
