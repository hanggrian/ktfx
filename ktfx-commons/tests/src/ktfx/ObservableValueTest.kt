package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValueTest {

    @Test fun hasValue() {
        val property = stringPropertyOf()
        assertFalse(property.hasValue())
        property.value = "Hello World"
        assertTrue(property.hasValue())
    }

    @Test fun clear() {
        val property = stringPropertyOf("Hello World")
        assertTrue(property.hasValue())
        property.clear()
        assertFalse(property.hasValue())
    }
}
