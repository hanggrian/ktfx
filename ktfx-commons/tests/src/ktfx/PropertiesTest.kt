package ktfx

import com.google.common.truth.Truth.assertThat
import javafx.beans.property.Property
import javafx.util.Duration
import ktfx.collections.emptyObservableList
import ktfx.collections.emptyObservableMap
import ktfx.collections.emptyObservableSet
import ktfx.util.minutes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/** Initial value test. */
class PropertiesTest {

    @Test fun any() = test<Duration>(propertyOf(), wrapperOf()) {
        assertNull(it.value)
        it.value = 1.minutes
        assertNotNull(it.value)
    }

    @Test fun boolean() = test(booleanPropertyOf(), booleanWrapperOf()) {
        assertFalse(it.value)
        it.value = true
        assertTrue(it.value)
    }

    @Test fun double() = test(doublePropertyOf(), doubleWrapperOf()) {
        assertEquals(0.0, it.value)
        it.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, it.value)
    }

    @Test fun float() = test(floatPropertyOf(), floatWrapperOf()) {
        assertEquals(0f, it.value)
        it.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, it.value)
    }

    @Test fun int() = test(intPropertyOf(), intWrapperOf()) {
        assertEquals(0, it.value)
        it.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, it.value)
    }

    @Test fun long() = test(longPropertyOf(), longWrapperOf()) {
        assertEquals(0L, it.value)
        it.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, it.value)
    }

    @Test fun string() = test(stringPropertyOf(), stringWrapperOf()) {
        assertNull(it.value)
        it.value = "Hello World"
        assertNotNull(it.value)
    }

    @Test fun list() = test(listPropertyOf<String>(), listWrapperOf<String>()) {
        assertNull(it.value)
        it.value = emptyObservableList()
        assertThat(it.value).isEmpty()
    }

    @Test fun set() = test(setPropertyOf<String>(), setWrapperOf<String>()) {
        assertNull(it.value)
        it.value = emptyObservableSet()
        assertThat(it.value).isEmpty()
    }

    @Test fun map() = test(mapPropertyOf<Int, String>(), mapWrapperOf<Int, String>()) {
        assertNull(it.value)
        it.value = emptyObservableMap()
        assertThat(it.value.keys).isEmpty()
    }

    inline fun <T> test(property: Property<T>, wrapper: Property<T>, action: (Property<T>) -> Unit) =
        listOf(property, wrapper).forEach { action(it) }
}
