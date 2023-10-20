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

class BindingsFloatTest {
    @Test
    fun multipleDependencies() {
        val dependency1 = floatPropertyOf(1f)
        val dependency2 = floatPropertyOf(2f)
        val binding1 =
            floatBindingOf(dependency1, dependency2) {
                dependency1.value + dependency2.value
            }
        assertEquals(3f, binding1.value)
        dependency1.value++
        assertEquals(4f, binding1.value)

        val dependency3 = floatPropertyOf(1f)
        val dependency4 = floatPropertyOf(2f)
        val binding2 =
            floatBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(3f, binding2.value)
        dependency3.value++
        assertEquals(4f, binding2.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.asFloat { it?.toMillis()?.toFloat() ?: 0f }
        assertEquals(60000f, binding.value)
        dependency.value = null
        assertEquals(0f, binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asFloat { if (it) Float.MAX_VALUE else Float.MIN_VALUE }
        assertEquals(Float.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Float.MAX_VALUE, binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asFloat { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toFloat(), binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asFloat { it }
        assertEquals(0f, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asFloat { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toFloat(), binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asFloat { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toFloat(), binding.value)
    }
}
