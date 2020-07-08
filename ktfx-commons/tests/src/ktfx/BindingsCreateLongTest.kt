package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsCreateLongTest {

    @Test fun multipleDependencies() {
        val dependency1 = longProperty(1)
        val dependency2 = longProperty(2)
        val binding = longBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3, binding.value)
        dependency1.value++
        assertEquals(4, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toLongBinding { it?.toMillis()?.toLong() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.value = null
        assertEquals(0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toLongBinding { if (it) Long.MAX_VALUE else Long.MIN_VALUE }
        assertEquals(Long.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Long.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toLong(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toLongBinding { it }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, binding.value)
    }
}
