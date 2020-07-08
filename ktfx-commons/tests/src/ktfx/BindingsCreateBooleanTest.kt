package ktfx

import ktfx.time.m
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsCreateBooleanTest {

    @Test fun multipleDependencies() {
        val dependency1 = booleanProperty(true)
        val dependency2 = booleanProperty(true)
        val binding = booleanBindingOf(dependency1, dependency2) { dependency1.value && dependency2.value }
        assertTrue(binding.value)
        dependency1.value = false
        assertFalse(binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toBooleanBinding { it == 60.s }
        assertTrue(binding.value)
        dependency.value = null
        assertFalse(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toBooleanBinding { !it }
        assertTrue(binding.value)
        dependency.value = true
        assertFalse(binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toBooleanBinding { it == 0.0 }
        assertTrue(binding.value)
        dependency.value = Double.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toBooleanBinding { it == 0f }
        assertTrue(binding.value)
        dependency.value = Float.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toBooleanBinding { it == 0 }
        assertTrue(binding.value)
        dependency.value = Int.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toBooleanBinding { it == 0L }
        assertTrue(binding.value)
        dependency.value = Long.MAX_VALUE
        assertFalse(binding.value)
    }
}
