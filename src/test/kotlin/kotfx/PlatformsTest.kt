package kotfx

import org.junit.Assert.assertEquals

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class PlatformsTest {

    //@Test
    fun test() {
        assertEquals(FEATURE_CONTROLS.isSupported, true)
        assertEquals(isSupported(FEATURE_CONTROLS, FEATURE_GRAPHICS), true)
        assertEquals(FEATURE_INPUT_TOUCH.isSupported, false)
    }
}