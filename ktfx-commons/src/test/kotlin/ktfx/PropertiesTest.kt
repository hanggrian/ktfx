package ktfx

import com.google.common.truth.Truth.assertThat
import javafx.beans.property.ReadOnlyObjectWrapper
import ktfx.collections.observableListOf
import ktfx.collections.observableMapOf
import ktfx.collections.observableSetOf
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

    @Test
    fun list() {
        assertThat(listPropertyOf(observableListOf(0))).containsExactly(0)
    }

    @Test
    fun set() {
        assertThat(setPropertyOf(observableSetOf(0))).containsExactly(0)
    }

    @Test
    fun map() {
        assertThat(mapPropertyOf(observableMapOf(0 to ""))).containsExactly(0, "")
    }
}
