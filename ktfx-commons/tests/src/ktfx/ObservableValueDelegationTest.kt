package ktfx

import ktfx.util.minutes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValueDelegationTest {
    private val duration = propertyOf(1.minutes)
    private var durationValue by duration

    private val boolean = booleanPropertyOf(false)
    private var booleanValue by boolean

    private var integer = intPropertyOf(1)
    private var integerValue by integer

    private val string = stringPropertyOf("Hello")
    private var stringValue by string

    private val emptyString = stringPropertyOf()

    @Test fun any() {
        assertEquals(1.minutes, durationValue)
        durationValue = 2.minutes
        assertEquals(2.minutes, duration.value)
    }

    @Test fun boolean() {
        assertFalse(booleanValue)
        booleanValue = true
        assertTrue(boolean.value)
    }

    @Test fun integer() {
        assertEquals(1, integerValue)
        integerValue = 2
        assertEquals(2, integer.value)
    }

    @Test fun string() {
        assertEquals("Hello", stringValue)
        stringValue = "World"
        assertEquals("World", string.value)

        assertFalse(string.toBooleanBinding { it.isNullOrBlank() }.value)
        assertTrue(emptyString.toBooleanBinding { it.isNullOrBlank() }.value)

        assertFalse(string.toBooleanBinding { it.isNullOrEmpty() }.value)
        assertTrue(emptyString.toBooleanBinding { it.isNullOrEmpty() }.value)

        assertEquals("World", string.toStringBinding { it.orEmpty() }.value)
        assertEquals("", emptyString.toStringBinding { it.orEmpty() }.value)

        assertEquals(IntRange(0, 4), string.toBinding { it!!.indices }.value)

        assertEquals(4, string.toIntBinding { it!!.lastIndex }.value)
    }
}