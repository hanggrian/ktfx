package kotfx

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
        assertEquals(FEATURE_CONTROLS.isSupported, true)
        assertEquals(isSupported(FEATURE_CONTROLS, FEATURE_GRAPHICS), true)
        assertEquals(FEATURE_INPUT_TOUCH.isSupported, false)
    }
}