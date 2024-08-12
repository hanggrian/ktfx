package ktfx.bindings

import ktfx.collections.observableIntArrayOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ArrayBindingsIntegerTest {
    @Test
    fun getBinding() {
        val numbers = observableIntArrayOf(1)
        val binding1 = numbers.getBinding(0)
        numbers[0] = 2
        assertEquals(2, binding1.value)
        val binding2 = numbers.getBinding(floatPropertyOf(0f))
        numbers[0] = 3
        assertEquals(3, binding2.value)
        val binding3 = numbers.getBinding(intPropertyOf(0))
        numbers[0] = 4
        assertEquals(4, binding3.value)
    }
}
