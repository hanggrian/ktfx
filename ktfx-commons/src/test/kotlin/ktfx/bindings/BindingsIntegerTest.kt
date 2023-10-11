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

class BindingsIntegerTest {
    @Test
    fun multipleDependencies() {
        val dependency1 = intPropertyOf(1)
        val dependency2 = intPropertyOf(2)
        val binding1 = intBindingOf(dependency1, dependency2) {
            dependency1.value + dependency2.value
        }
        assertEquals(3, binding1.value)
        dependency1.value++
        assertEquals(4, binding1.value)

        val dependency3 = intPropertyOf(1)
        val dependency4 = intPropertyOf(2)
        val binding2 = intBindingOf(listOf(dependency3, dependency4)) {
            dependency3.value + dependency4.value
        }
        assertEquals(3, binding2.value)
        dependency3.value++
        assertEquals(4, binding2.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.asInt { it?.toMillis()?.toInt() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.value = null
        assertEquals(0, binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asInt { if (it) Int.MAX_VALUE else Int.MIN_VALUE }
        assertEquals(Int.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asInt { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toInt(), binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asInt { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toInt(), binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asInt { it }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asInt { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toInt(), binding.value)
    }
}
