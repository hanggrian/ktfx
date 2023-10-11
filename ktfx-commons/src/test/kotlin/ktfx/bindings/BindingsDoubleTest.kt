package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsDoubleTest {
    @Test
    fun multipleDependencies() {
        val dependency1 = doublePropertyOf(1.0)
        val dependency2 = doublePropertyOf(2.0)
        val binding1 = doubleBindingOf(dependency1, dependency2) {
            dependency1.value + dependency2.value
        }
        assertEquals(3.0, binding1.value)
        dependency1.value++
        assertEquals(4.0, binding1.value)

        val dependency3 = doublePropertyOf(1.0)
        val dependency4 = doublePropertyOf(2.0)
        val binding2 = doubleBindingOf(listOf(dependency3, dependency4)) {
            dependency3.value + dependency4.value
        }
        assertEquals(3.0, binding2.value)
        dependency3.value++
        assertEquals(4.0, binding2.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.asDouble { it?.toMillis() ?: 0.0 }
        assertEquals(60000.0, binding.value)
        dependency.value = null
        assertEquals(0.0, binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asDouble { if (it) Double.MAX_VALUE else Double.MIN_VALUE }
        assertEquals(Double.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asDouble { it }
        assertEquals(0.0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asDouble { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble(), binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asDouble { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toDouble(), binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asDouble { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toDouble(), binding.value)
    }
}
