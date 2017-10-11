package kotfx

import javafx.application.ConditionalFeature.*
import org.junit.Assert.assertEquals

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class PlatformsTest {

    // @Rule
    // @JvmField
    val rule = JavaFXThreadingRule()

    // @Test
    fun test() {
        assertEquals(isSupported(CONTROLS), true)
        assertEquals(isSupported(CONTROLS, GRAPHICS), true)
        assertEquals(isSupported(INPUT_TOUCH), false)
    }
}