package ktfx.bindings

import javafx.util.Duration
import ktfx.collections.mutableObservableMapOf
import ktfx.propertyOf
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CollectionsBindingsMap {
    @Test
    fun `Bind and unbind content bidirectionally`() {
        val numbers1 = mutableObservableMapOf<Int, Int>()
        val numbers2 = mutableObservableMapOf<Int, Int>()

        numbers1.bindContentBidirectional(numbers2)
        numbers1[0] = 1
        numbers1[1] = 2
        assertEquals(1, numbers2[0])
        assertEquals(2, numbers2[1])

        numbers1.unbindContentBidirectional(numbers2)
        numbers1.clear()
        assertEquals(1, numbers2[0])
        assertEquals(2, numbers2[1])
    }

    @Test
    fun `Bind and unbind content`() {
        val numbers1 = mutableObservableMapOf<Int, Int>()
        val numbers2 = mutableObservableMapOf<Int, Int>()

        numbers1.bindContent(numbers2)
        numbers1[0] = 1
        numbers1[1] = 2
        assertEquals(1, numbers1[0])
        assertEquals(2, numbers1[1])

        numbers1.unbindContent(numbers2)
        numbers2.clear()
        assertEquals(1, numbers1[0])
        assertEquals(2, numbers1[1])
    }

    @Test
    fun sizeBinding() {
        val numbers = mutableObservableMapOf(0 to 1)
        val binding = numbers.sizeBinding
        assertEquals(1, binding.value)
        numbers.clear()
        assertEquals(0, binding.value)
    }

    @Test
    fun emptyBinding() {
        val numbers = mutableObservableMapOf(0 to 1)
        val binding = numbers.emptyBinding
        assertFalse(binding.value)
        numbers.clear()
        assertTrue(binding.value)
    }

    @Test
    fun notEmptyBinding() {
        val numbers = mutableObservableMapOf(0 to 1)
        val binding = numbers.notEmptyBinding
        assertTrue(binding.value)
        numbers.clear()
        assertFalse(binding.value)
    }

    @Test
    fun getBinding() {
        val objects = mutableObservableMapOf(0 to Duration.ZERO)
        val binding1 = objects.getBinding(0)
        objects[0] = 1.m
        assertEquals(1.m, binding1.value)
        val binding2 = objects.getBinding(propertyOf(0))
        objects[0] = 2.m
        assertEquals(2.m, binding2.value)

        val booleans = mutableObservableMapOf(0 to false)
        val booleanBinding1 = booleans.getBinding(0)
        booleans[0] = true
        assertTrue(booleanBinding1.value)
        val booleanBinding2 = booleans.getBinding(propertyOf(0))
        booleans[0] = false
        assertFalse(booleanBinding2.value)

        val doubles = mutableObservableMapOf(0 to 0.0)
        val doubleBinding1 = doubles.getBinding(0)
        doubles[0] = 1.0
        assertEquals(1.0, doubleBinding1.value)
        val doubleBinding2 = doubles.getBinding(propertyOf(0))
        doubles[0] = 2.0
        assertEquals(2.0, doubleBinding2.value)

        val floats = mutableObservableMapOf(0 to 0f)
        val floatBinding1 = floats.getBinding(0)
        floats[0] = 1f
        assertEquals(1f, floatBinding1.value)
        val floatBinding2 = floats.getBinding(propertyOf(0))
        floats[0] = 2f
        assertEquals(2f, floatBinding2.value)

        val ints = mutableObservableMapOf(0 to 1)
        val intBinding1 = ints.getBinding(0)
        ints[0] = 2
        assertEquals(2, intBinding1.value)
        val intBinding2 = ints.getBinding(propertyOf(0))
        ints[0] = 3
        assertEquals(3, intBinding2.value)

        val longs = mutableObservableMapOf(0 to 1L)
        val longBinding1 = longs.getBinding(0)
        longs[0] = 2L
        assertEquals(2L, longBinding1.value)
        val longBinding2 = longs.getBinding(propertyOf(0))
        longs[0] = 3L
        assertEquals(3L, longBinding2.value)

        val strings = mutableObservableMapOf(0 to "")
        val stringBinding1 = strings.getBinding(0)
        strings[0] = "Lorem"
        assertEquals("Lorem", stringBinding1.value)
        val stringBinding2 = strings.getBinding(propertyOf(0))
        strings[0] = "Ipsum"
        assertEquals("Ipsum", stringBinding2.value)
    }
}
