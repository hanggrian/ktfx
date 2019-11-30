package ktfx

import ktfx.util.minutes
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingCreateStringTest {

    @Test fun multipleDependencies() {
        val dependency1 = stringPropertyOf("Hello")
        val dependency2 = stringPropertyOf("World")
        val binding = stringBindingOf(dependency1, dependency2) { dependency1.value + ' ' + dependency2.value }
        assertEquals("Hello World", binding.value)
        dependency1.value = "Goodbye"
        assertEquals("Goodbye World", binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("60000.0 ms", binding.value)
        dependency.clear()
        assertEquals("null", binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("false", binding.value)
        dependency.value = true
        assertEquals("true", binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toString(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toString(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toString(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toString(), binding.value)
    }
}