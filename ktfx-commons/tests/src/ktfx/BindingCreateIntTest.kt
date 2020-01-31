package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingCreateIntTest {

    @Test fun multipleDependencies() {
        val dependency1 = intPropertyOf(1)
        val dependency2 = intPropertyOf(2)
        val binding = intBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3, binding.value)
        dependency1.value++
        assertEquals(4, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.toIntBinding { it?.toMillis()?.toInt() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.clear()
        assertEquals(0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toIntBinding { if (it) Int.MAX_VALUE else Int.MIN_VALUE }
        assertEquals(Int.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toInt(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toInt(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toIntBinding { it }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toInt(), binding.value)
    }
}
