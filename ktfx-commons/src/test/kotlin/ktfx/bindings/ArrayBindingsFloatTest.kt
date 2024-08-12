package ktfx.bindings

import ktfx.collections.observableFloatArrayOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ArrayBindingsFloatTest {
    @Test
    fun getBinding() {
        val numbers = observableFloatArrayOf(1f)
        val binding1 = numbers.getBinding(0)
        numbers[0] = 2f
        assertEquals(2f, binding1.value)
        val binding2 = numbers.getBinding(floatPropertyOf(0f))
        numbers[0] = 3f
        assertEquals(3f, binding2.value)
        val binding3 = numbers.getBinding(intPropertyOf(0))
        numbers[0] = 4f
        assertEquals(4f, binding3.value)
    }
}
