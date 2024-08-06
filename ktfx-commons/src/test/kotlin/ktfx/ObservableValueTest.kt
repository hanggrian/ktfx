package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueTest {
    private val objectProperty = propertyOf<javafx.util.Duration>()
    private var object2 by objectProperty

    private val stringValueProperty = stringPropertyOf()
    private var stringValue by stringValueProperty

    private val booleanValueProperty = booleanPropertyOf()
    private var booleanValue by booleanValueProperty

    private val doubleValueProperty = doublePropertyOf()
    private var doubleValue by doubleValueProperty

    private val floatValueProperty = floatPropertyOf()
    private var floatValue by floatValueProperty

    private val longValueProperty = longPropertyOf()
    private var longValue by longValueProperty

    private val intValueProperty = intPropertyOf()
    private var intValue by intValueProperty

    @Test
    fun `object`() {
        assertNull(object2)
        object2 = 2.m
        assertEquals(2.m, objectProperty.value)
    }

    @Test
    fun string() {
        assertNull(stringValue)
        stringValue = "Hello World"
        assertEquals("Hello World", stringValueProperty.value)
    }

    @Test
    fun boolean() {
        assertFalse(booleanValue)
        booleanValue = true
        assertTrue(booleanValueProperty.value)
    }

    @Test
    fun double() {
        assertEquals(0.0, doubleValue)
        doubleValue = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, doubleValueProperty.value)
    }

    @Test
    fun float() {
        assertEquals(0f, floatValue)
        floatValue = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, floatValueProperty.value)
    }

    @Test
    fun long() {
        assertEquals(0L, longValue)
        longValue = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, longValueProperty.value)
    }

    @Test
    fun int() {
        assertEquals(0, intValue)
        intValue = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, intValueProperty.value)
    }
}
