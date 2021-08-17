package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.minutes
import ktfx.time.plus
import ktfx.time.seconds
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingsObjectTest {

    @Test
    fun nullability() {
        val dependency = propertyOf<String>()
        val binding = bindingOf<String>(dependency) { null }
        assertNull(binding.get())
    }

    @Test
    fun multipleDependencies() {
        val dependency1 = propertyOf(1.minutes)
        val dependency2 = propertyOf(30.seconds)
        val binding1 = bindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(90.seconds, binding1.value)
        dependency1.value = 15.seconds
        assertEquals(45.seconds, binding1.value)

        val dependency3 = propertyOf(1.minutes)
        val dependency4 = propertyOf(30.seconds)
        val binding2 = bindingOf(listOf(dependency3, dependency4)) { dependency3.value + dependency4.value }
        assertEquals(90.seconds, binding2.value)
        dependency3.value = 15.seconds
        assertEquals(45.seconds, binding2.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.asAny { it }
        assertEquals(60.seconds, binding.value)
        dependency.value = null
        assertNull(binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asAny { if (it) 1.seconds else 2.seconds }
        assertEquals(2.seconds, binding.value)
        dependency.value = true
        assertEquals(1.seconds, binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asAny { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.seconds, binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asAny { it.toDouble().seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble().seconds, binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asAny { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.seconds, binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asAny { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.seconds, binding.value)
    }
}
