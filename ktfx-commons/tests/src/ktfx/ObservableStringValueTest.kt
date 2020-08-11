package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableStringValueTest {
    private val stringProperty = stringProperty()
    private var string by stringProperty

    @Test fun delegate() {
        assertNull(string)
        string = "Hello World"
        assertEquals("Hello World", stringProperty.value)
    }

    @Test fun eq() {
        assertFalse((stringProperty() eq stringProperty("Hendra")).value)
        assertTrue((stringProperty("Anggrian") eq stringProperty("Anggrian")).value)
    }

    @Test fun neq() {
        assertTrue((stringProperty() neq stringProperty("Hendra")).value)
        assertFalse((stringProperty("Anggrian") neq stringProperty("Anggrian")).value)
    }
}
