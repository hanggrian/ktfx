package ktfx.text

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

    @Test fun weight() = assertEquals(FontWeight.BOLD, Font.font("Arial", FontWeight.BOLD, 14.0).weight)

    @Test fun posture() = assertEquals(FontPosture.ITALIC, Font.font("Arial", FontPosture.ITALIC, 14.0).posture)
}
