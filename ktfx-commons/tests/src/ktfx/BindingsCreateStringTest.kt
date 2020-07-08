package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsCreateStringTest {

    @Test fun multipleDependencies() {
        val dependency1 = stringProperty("Hello")
        val dependency2 = stringProperty("World")
        val binding = stringBindingOf(dependency1, dependency2) { dependency1.value + ' ' + dependency2.value }
        assertEquals("Hello World", binding.value)
        dependency1.value = "Goodbye"
        assertEquals("Goodbye World", binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("60000.0 ms", binding.value)
        dependency.value = null
        assertEquals("null", binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("false", binding.value)
        dependency.value = true
        assertEquals("true", binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toString(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toString(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toString(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toString(), binding.value)
    }
}
