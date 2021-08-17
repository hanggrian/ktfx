package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.minutes
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsLongTest {

    @Test
    fun multipleDependencies() {
        val dependency1 = longPropertyOf(1)
        val dependency2 = longPropertyOf(2)
        val binding1 = longBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3, binding1.value)
        dependency1.value++
        assertEquals(4, binding1.value)

        val dependency3 = longPropertyOf(1)
        val dependency4 = longPropertyOf(2)
        val binding2 = longBindingOf(listOf(dependency3, dependency4)) { dependency3.value + dependency4.value }
        assertEquals(3, binding2.value)
        dependency3.value++
        assertEquals(4, binding2.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.asLong { it?.toMillis()?.toLong() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.value = null
        assertEquals(0, binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asLong { if (it) Long.MAX_VALUE else Long.MIN_VALUE }
        assertEquals(Long.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Long.MAX_VALUE, binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asLong { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toLong(), binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asLong { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toLong(), binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asLong { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toLong(), binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asLong { it }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, binding.value)
    }
}
