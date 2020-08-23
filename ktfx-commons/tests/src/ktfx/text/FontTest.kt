package ktfx.text

import javafx.scene.control.Label
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import kotlin.test.Test
import kotlin.test.assertEquals

class FontTest {

    @Test fun pt() {
        assertEquals(Font.font(18.0), 18.0.pt)
        assertEquals(Font.font(12.0), 12.pt)
    }

    @Test fun font() {
        val label = Label()
        label.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 12)
        assertEquals("Arial", label.font.family)
        assertEquals(FontWeight.BOLD, label.font.weight)
        assertEquals(FontPosture.ITALIC, label.font.posture)
        assertEquals(12.0, label.font.size)
    }

    @Test fun weight() = assertEquals(FontWeight.BOLD, Font.font("Arial", FontWeight.BOLD, 14.0).weight)

    @Test fun posture() = assertEquals(FontPosture.ITALIC, Font.font("Arial", FontPosture.ITALIC, 14.0).posture)
}
