package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class PropertiesPrimitivesTest {

    @Test fun boolean() {
        assertFalse(propertyOf<Boolean>().asPrimitive().value)
        assertFalse(wrapperOf<Boolean>().readOnlyProperty.asPrimitive().value)
    }

    @Test fun double() {
        assertEquals(0.0, propertyOf<Double>().asPrimitive().value)
        assertEquals(0.0, wrapperOf<Double>().readOnlyProperty.asPrimitive().value)
    }

    @Test fun float() {
        assertEquals(0f, propertyOf<Float>().asPrimitive().value)
        assertEquals(0f, wrapperOf<Float>().readOnlyProperty.asPrimitive().value)
    }

    @Test fun int() {
        assertEquals(0, propertyOf<Int>().asPrimitive().value)
        assertEquals(0, wrapperOf<Int>().readOnlyProperty.asPrimitive().value)
    }

    @Test fun long() {
        assertEquals(0L, propertyOf<Long>().asPrimitive().value)
        assertEquals(0L, wrapperOf<Long>().readOnlyProperty.asPrimitive().value)
    }
}