package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorStringTest {

    @Test fun eq() {
        assertFalse((stringPropertyOf() eq stringPropertyOf("Hendra")).value)
        assertTrue((stringPropertyOf("Anggrian") eq stringPropertyOf("Anggrian")).value)
    }

    @Test fun neq() {
        assertTrue((stringPropertyOf() neq stringPropertyOf("Hendra")).value)
        assertFalse((stringPropertyOf("Anggrian") neq stringPropertyOf("Anggrian")).value)
    }
}
