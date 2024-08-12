package ktfx.bindings

import javafx.util.Duration
import ktfx.collections.mutableObservableListOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CollectionsBindingsList {
    @Test
    fun `Bind and unbind content bidirectionally`() {
        val numbers1 = mutableObservableListOf<Int>()
        val numbers2 = mutableObservableListOf<Int>()

        numbers1.bindContentBidirectional(numbers2)
        numbers1 += 1
        numbers1 += 2
        assertEquals(1, numbers2[0])
        assertEquals(2, numbers2[1])

        numbers1.unbindContentBidirectional(numbers2)
        numbers1.clear()
        assertEquals(1, numbers2[0])
        assertEquals(2, numbers2[1])
    }

    @Test
    fun `Bind and unbind content`() {
        val numbers1 = mutableObservableListOf<Int>()
        val numbers2 = mutableObservableListOf<Int>()

        numbers1.bindContent(numbers2)
        numbers2 += 1
        numbers2 += 2
        assertEquals(1, numbers1[0])
        assertEquals(2, numbers1[1])

        numbers1.unbindContent(numbers2)
        numbers2.clear()
        assertEquals(1, numbers1[0])
        assertEquals(2, numbers1[1])
    }

    @Test
    fun sizeBinding() {
        val numbers = mutableObservableListOf(1)
        val binding = numbers.sizeBinding
        assertEquals(1, binding.value)
        numbers.clear()
        assertEquals(0, binding.value)
    }

    @Test
    fun emptyBinding() {
        val numbers = mutableObservableListOf(1)
        val binding = numbers.emptyBinding
        assertFalse(binding.value)
        numbers.clear()
        assertTrue(binding.value)
    }

    @Test
    fun notEmptyBinding() {
        val numbers = mutableObservableListOf(1)
        val binding = numbers.notEmptyBinding
        assertTrue(binding.value)
        numbers.clear()
        assertFalse(binding.value)
    }

    @Test
    fun getBinding() {
        val objects = mutableObservableListOf(Duration.ZERO)
        val binding1 = objects.getBinding(0)
        objects[0] = 1.m
        assertEquals(1.m, binding1.value)
        val binding2 = objects.getBinding(floatPropertyOf(0f))
        objects[0] = 2.m
        assertEquals(2.m, binding2.value)
        val binding3 = objects.getBinding(intPropertyOf(0))
        objects[0] = 3.m
        assertEquals(3.m, binding3.value)

        val booleans = mutableObservableListOf(false)
        val booleanBinding1 = booleans.getBinding(0)
        booleans[0] = true
        assertTrue(booleanBinding1.value)
        val booleanBinding2 = booleans.getBinding(floatPropertyOf(0f))
        booleans[0] = false
        assertFalse(booleanBinding2.value)
        val booleanBinding3 = booleans.getBinding(intPropertyOf(0))
        booleans[0] = true
        assertTrue(booleanBinding3.value)

        val doubles = mutableObservableListOf(0.0)
        val doubleBinding1 = doubles.getBinding(0)
        doubles[0] = 1.0
        assertEquals(1.0, doubleBinding1.value)
        val doubleBinding2 = doubles.getBinding(floatPropertyOf(0f))
        doubles[0] = 2.0
        assertEquals(2.0, doubleBinding2.value)
        val doubleBinding3 = doubles.getBinding(intPropertyOf(0))
        doubles[0] = 3.0
        assertEquals(3.0, doubleBinding3.value)

        val floats = mutableObservableListOf(0f)
        val floatBinding1 = floats.getBinding(0)
        floats[0] = 1f
        assertEquals(1f, floatBinding1.value)
        val floatBinding2 = floats.getBinding(floatPropertyOf(0f))
        floats[0] = 2f
        assertEquals(2f, floatBinding2.value)
        val floatBinding3 = floats.getBinding(intPropertyOf(0))
        floats[0] = 3f
        assertEquals(3f, floatBinding3.value)

        val ints = mutableObservableListOf(1)
        val intBinding1 = ints.getBinding(0)
        ints[0] = 2
        assertEquals(2, intBinding1.value)
        val intBinding2 = ints.getBinding(floatPropertyOf(0f))
        ints[0] = 3
        assertEquals(3, intBinding2.value)
        val intBinding3 = ints.getBinding(intPropertyOf(0))
        ints[0] = 4
        assertEquals(4, intBinding3.value)

        val longs = mutableObservableListOf(1L)
        val longBinding1 = longs.getBinding(0)
        longs[0] = 2L
        assertEquals(2L, longBinding1.value)
        val longBinding2 = longs.getBinding(floatPropertyOf(0f))
        longs[0] = 3L
        assertEquals(3L, longBinding2.value)
        val longBinding3 = longs.getBinding(intPropertyOf(0))
        longs[0] = 4L
        assertEquals(4L, longBinding3.value)

        val strings = mutableObservableListOf("")
        val stringBinding1 = strings.getBinding(0)
        strings[0] = "Lorem"
        assertEquals("Lorem", stringBinding1.value)
        val stringBinding2 = strings.getBinding(floatPropertyOf(0f))
        strings[0] = "Ipsum"
        assertEquals("Ipsum", stringBinding2.value)
        val stringBinding3 = strings.getBinding(intPropertyOf(0))
        strings[0] = "Dolor"
        assertEquals("Dolor", stringBinding3.value)
    }
}
