package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.collections.observableMapOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.m
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingsMapTest {

    @Test fun multipleDependencies() {
        val dependency1 = propertyOf(1.m)
        val dependency2 = propertyOf(30.s)
        val binding = mapBindingOf(
            dependency1,
            dependency2
        ) { observableMapOf(dependency1.value to dependency2.value) }
        assertEquals(1.m, binding.value.keys.first())
        dependency1.value = 15.s
        assertEquals(30.s, binding.value.values.first())
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.m)
        val binding = dependency.asMap { it?.let { observableMapOf(0 to it.toMillis()) } }
        assertEquals(60000.0, binding.value[0])
        dependency.value = null
        assertNull(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asMap { observableMapOf(0 to it) }
        assertEquals(false, binding.value[0])
        dependency.value = true
        assertEquals(true, binding.value[0])
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asMap { observableMapOf(0 to it) }
        assertEquals(0.0, binding.value[0])
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, binding.value[0])
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asMap { observableMapOf(0 to it) }
        assertEquals(0f, binding.value[0])
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, binding.value[0])
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asMap { observableMapOf(0 to it) }
        assertEquals(0, binding.value[0])
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, binding.value[0])
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asMap { observableMapOf(0 to it) }
        assertEquals(0L, binding.value[0])
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, binding.value[0])
    }
}
