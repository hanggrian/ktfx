package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.stringPropertyOf
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsStringTest {

    @Test fun multipleDependencies() {
        val dependency1 = stringPropertyOf("Hello")
        val dependency2 = stringPropertyOf("World")
        val binding1 = stringBindingOf(dependency1, dependency2) { dependency1.value + ' ' + dependency2.value }
        assertEquals("Hello World", binding1.value)
        dependency1.value = "Goodbye"
        assertEquals("Goodbye World", binding1.value)

        val dependency3 = stringPropertyOf("Hello")
        val dependency4 = stringPropertyOf("World")
        val binding2 = stringBindingOf(listOf(dependency3, dependency4)) { dependency3.value + ' ' + dependency4.value }
        assertEquals("Hello World", binding2.value)
        dependency3.value = "Goodbye"
        assertEquals("Goodbye World", binding2.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.asString { it.toString() }
        assertEquals("60000.0 ms", binding.value)
        dependency.value = null
        assertEquals("null", binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asString { it.toString() }
        assertEquals("false", binding.value)
        dependency.value = true
        assertEquals("true", binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asString { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toString(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asString { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toString(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asString { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toString(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asString { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toString(), binding.value)
    }
}
