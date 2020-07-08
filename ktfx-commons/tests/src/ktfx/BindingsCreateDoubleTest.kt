package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsCreateDoubleTest {

    @Test fun multipleDependencies() {
        val dependency1 = doubleProperty(1.0)
        val dependency2 = doubleProperty(2.0)
        val binding = doubleBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3.0, binding.value)
        dependency1.value++
        assertEquals(4.0, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toDoubleBinding { it?.toMillis() ?: 0.0 }
        assertEquals(60000.0, binding.value)
        dependency.value = null
        assertEquals(0.0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toDoubleBinding { if (it) Double.MAX_VALUE else Double.MIN_VALUE }
        assertEquals(Double.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toDoubleBinding { it }
        assertEquals(0.0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toDouble(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toDouble(), binding.value)
    }
}
