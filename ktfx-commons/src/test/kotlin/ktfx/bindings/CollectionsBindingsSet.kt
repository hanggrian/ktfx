package ktfx.bindings

import ktfx.collections.mutableObservableSetOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CollectionsBindingsSet {
    @Test
    fun `Bind and unbind content bidirectionally`() {
        val numbers1 = mutableObservableSetOf<Int>()
        val numbers2 = mutableObservableSetOf<Int>()

        numbers1.bindContentBidirectional(numbers2)
        numbers1 += 1
        numbers1 += 2
        assertEquals(2, numbers2.size)

        numbers1.unbindContentBidirectional(numbers2)
        numbers1.clear()
        assertEquals(2, numbers2.size)
    }

    @Test
    fun `Bind and unbind content`() {
        val numbers1 = mutableObservableSetOf<Int>()
        val numbers2 = mutableObservableSetOf<Int>()

        numbers1.bindContent(numbers2)
        numbers2 += 1
        numbers2 += 2
        assertEquals(2, numbers1.size)

        numbers1.unbindContent(numbers2)
        numbers2.clear()
        assertEquals(2, numbers1.size)
    }

    @Test
    fun sizeBinding() {
        val numbers = mutableObservableSetOf(1)
        val binding = numbers.sizeBinding
        assertEquals(1, binding.value)
        numbers.clear()
        assertEquals(0, binding.value)
    }

    @Test
    fun emptyBinding() {
        val numbers = mutableObservableSetOf(1)
        val binding = numbers.emptyBinding
        assertFalse(binding.value)
        numbers.clear()
        assertTrue(binding.value)
    }

    @Test
    fun notEmptyBinding() {
        val numbers = mutableObservableSetOf(1)
        val binding = numbers.notEmptyBinding
        assertTrue(binding.value)
        numbers.clear()
        assertFalse(binding.value)
    }
}
