package ktfx

import javafx.beans.property.ReadOnlyObjectWrapper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class PropertiesTest {

    @Test
    fun boolean() {
        assertFalse(propertyOf(false).asPrimitive().value)
        assertFalse(ReadOnlyObjectWrapper(false).readOnlyProperty.asPrimitive().value)
    }

    @Test
    fun double() {
        assertEquals(0.0, propertyOf(0.0).asPrimitive().value)
        assertEquals(0.0, ReadOnlyObjectWrapper(0.0).readOnlyProperty.asPrimitive().value)
    }

    @Test
    fun float() {
        assertEquals(0f, propertyOf(0f).asPrimitive().value)
        assertEquals(0f, ReadOnlyObjectWrapper(0f).readOnlyProperty.asPrimitive().value)
    }

    @Test
    fun int() {
        assertEquals(0, propertyOf(0).asPrimitive().value)
        assertEquals(0, ReadOnlyObjectWrapper(0).readOnlyProperty.asPrimitive().value)
    }

    @Test
    fun long() {
        assertEquals(0L, propertyOf(0L).asPrimitive().value)
        assertEquals(0L, ReadOnlyObjectWrapper(0L).readOnlyProperty.asPrimitive().value)
    }
}
