package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals

class ObservableNumberValueTest {
    private val doubleProperty = doubleProperty()
    private var double by doubleProperty
    private val floatProperty = floatProperty()
    private var float by floatProperty
    private val intProperty = intProperty()
    private var int by intProperty
    private val longProperty = longProperty()
    private var long by longProperty

    @Test fun delegateDouble() {
        assertEquals(0.0, double)
        double = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, doubleProperty.value)
    }

    @Test fun delegateFloat() {
        assertEquals(0f, float)
        float = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, floatProperty.value)
    }

    @Test fun delegateInt() {
        assertEquals(0, int)
        int = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, intProperty.value)
    }

    @Test fun delegateLong() {
        assertEquals(0L, long)
        long = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, longProperty.value)
    }

    @Test fun doublePlus() {
        assertEquals(3.0, (1.0 + doubleProperty(2.0)).value)
        assertEquals(3.0, (doubleProperty(1.0) + doubleProperty(2.0)).value)
        assertEquals(3.0, (doubleProperty(1.0) + 2.0).value)
        assertEquals(3.0, (doubleProperty(1.0) + 2f).value)
        assertEquals(3.0, (doubleProperty(1.0) + 2L).value)
        assertEquals(3.0, (doubleProperty(1.0) + 2).value)
    }

    /*@Test*/ fun floatPlus() {
        //assertEquals(3f, (1f + doubleProperty(2.0)).value)
        assertEquals(3f, (floatProperty(1f) + doubleProperty(2.0)).value)
        assertEquals(3.0, (floatProperty(1f) + 2.0).value)
        assertEquals(3f, (floatProperty(1f) + 2F).value)
        assertEquals(3f, (floatProperty(1f) + 2L).value)
        assertEquals(3f, (floatProperty(1f) + 2).value)
    }

    /*@Test*/ fun longPlus() {
        //assertEquals(3L, (1L + doubleProperty(2.0)).value)
        assertEquals(3L, (longProperty(1L) + doubleProperty(2.0)).value)
        assertEquals(3.0, (longProperty(1L) + 2.0).value)
        assertEquals(3f, (longProperty(1L) + 2F).value)
        assertEquals(3L, (longProperty(1L) + 2L).value)
        assertEquals(3L, (longProperty(1L) + 2).value)
    }

    /*@Test*/ fun intPlus() {
        //assertEquals(3, (1 + doubleProperty(2.0)).value)
        assertEquals(3, (intProperty(1) + doubleProperty(2.0)).value)
        assertEquals(3.0, (intProperty(1) + 2.0).value)
        assertEquals(3f, (intProperty(1) + 2F).value)
        assertEquals(3, (intProperty(1) + 2L).value)
        assertEquals(3, (intProperty(1) + 2).value)
    }
}
