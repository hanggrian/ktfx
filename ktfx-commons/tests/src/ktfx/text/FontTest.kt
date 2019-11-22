package ktfx.text

import javafx.scene.text.Font
import kotlin.test.Test
import kotlin.test.assertEquals

class FontTest {

    @Test fun pt() {
        assertEquals(Font.font(18.0), 18.0.pt)
        assertEquals(Font.font(12.0), 12.pt)
    }
}