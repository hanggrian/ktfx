package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.util.minutes

class BindingCreateLongTest {

    @Test fun multipleDependencies() {
        val dependency1 = longPropertyOf(1)
        val dependency2 = longPropertyOf(2)
        val binding = longBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3, binding.value)
        dependency1.value++
        assertEquals(4, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.toLongBinding { it?.toMillis()?.toLong() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.clear()
        assertEquals(0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toLongBinding { if (it) Long.MAX_VALUE else Long.MIN_VALUE }
        assertEquals(Long.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Long.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toLongBinding { it }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, binding.value)
    }
}
