package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.util.minutes

class BindingCreateDoubleTest {

    @Test fun multipleDependencies() {
        val dependency1 = doublePropertyOf(1.0)
        val dependency2 = doublePropertyOf(2.0)
        val binding = doubleBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3.0, binding.value)
        dependency1.value++
        assertEquals(4.0, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.toDoubleBinding { it?.toMillis() ?: 0.0 }
        assertEquals(60000.0, binding.value)
        dependency.clear()
        assertEquals(0.0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toDoubleBinding { if (it) Double.MAX_VALUE else Double.MIN_VALUE }
        assertEquals(Double.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toDoubleBinding { it }
        assertEquals(0.0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toDouble(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toDouble(), binding.value)
    }
}
