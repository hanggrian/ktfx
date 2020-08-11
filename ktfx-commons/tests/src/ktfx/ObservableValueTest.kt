package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueTest {
    private val objectProperty = propertyOf<javafx.util.Duration>()
    private var `object` by objectProperty

    @Test fun `object`() {
        assertNull(`object`)
        `object` = 2.m
        assertEquals(2.m, objectProperty.value)
    }

    private val stringProperty = stringPropertyOf()
    private var string by stringProperty

    @Test fun string() {
        assertNull(string)
        string = "Hello World"
        assertEquals("Hello World", stringProperty.value)
    }

    private val booleanProperty = booleanPropertyOf()
    private var boolean by booleanProperty

    @Test fun boolean() {
        assertFalse(boolean)
        boolean = true
        assertTrue(booleanProperty.value)
    }

    private val doubleProperty = doublePropertyOf()
    private var double by doubleProperty

    @Test fun double() {
        assertEquals(0.0, double)
        double = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, doubleProperty.value)
    }

    private val floatProperty = floatPropertyOf()
    private var float by floatProperty

    @Test fun float() {
        assertEquals(0f, float)
        float = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, floatProperty.value)
    }

    private val longProperty = longPropertyOf()
    private var long by longProperty

    @Test fun long() {
        assertEquals(0L, long)
        long = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, longProperty.value)
    }

    private val intProperty = intPropertyOf()
    private var int by intProperty

    @Test fun int() {
        assertEquals(0, int)
        int = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, intProperty.value)
    }
}