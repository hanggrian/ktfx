package ktfx.bindings

import javafx.util.Duration
import ktfx.booleanPropertyOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.m
import ktfx.time.plus
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingsObjectTest {

    @Test fun nullability() {
        val dependency = propertyOf<String>()
        val binding = bindingOf<String>(dependency) { null }
        assertNull(binding.get())
    }

    @Test fun multipleDependencies() {
        val dependency1 = propertyOf(1.m)
        val dependency2 = propertyOf(30.s)
        val binding = bindingOf(
            dependency1,
            dependency2
        ) { dependency1.value + dependency2.value }
        assertEquals(90.s, binding.value)
        dependency1.value = 15.s
        assertEquals(45.s, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.toBinding { it }
        assertEquals(60.s, binding.value)
        dependency.value = null
        assertNull(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toBinding { if (it) 1.s else 2.s }
        assertEquals(2.s, binding.value)
        dependency.value = true
        assertEquals(1.s, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.s, binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toBinding<Duration> { it.toDouble().s }
        assertEquals(0.s, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble().s, binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.s, binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.s, binding.value)
    }
}
