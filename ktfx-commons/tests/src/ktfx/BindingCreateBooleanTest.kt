package ktfx

import ktfx.time.m
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingCreateBooleanTest {

    @Test fun multipleDependencies() {
        val dependency1 = booleanPropertyOf(true)
        val dependency2 = booleanPropertyOf(true)
        val binding = booleanBindingOf(dependency1, dependency2) { dependency1.value && dependency2.value }
        assertTrue(binding.value)
        dependency1.value = false
        assertFalse(binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.toBooleanBinding { it == 60.s }
        assertTrue(binding.value)
        dependency.clear()
        assertFalse(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toBooleanBinding { !it }
        assertTrue(binding.value)
        dependency.value = true
        assertFalse(binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toBooleanBinding { it == 0.0 }
        assertTrue(binding.value)
        dependency.value = Double.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toBooleanBinding { it == 0f }
        assertTrue(binding.value)
        dependency.value = Float.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toBooleanBinding { it == 0 }
        assertTrue(binding.value)
        dependency.value = Int.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toBooleanBinding { it == 0L }
        assertTrue(binding.value)
        dependency.value = Long.MAX_VALUE
        assertFalse(binding.value)
    }
}
