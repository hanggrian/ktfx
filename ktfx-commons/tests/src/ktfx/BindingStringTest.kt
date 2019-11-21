package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingStringTest {

    @Test fun eq() {
        assertFalse((stringProperty() eq stringProperty("Hendra")).value)
        assertTrue((stringProperty("Anggrian") eq stringProperty("Anggrian")).value)
    }

    @Test fun neq() {
        assertTrue((stringProperty() neq stringProperty("Hendra")).value)
        assertFalse((stringProperty("Anggrian") neq stringProperty("Anggrian")).value)
    }
}