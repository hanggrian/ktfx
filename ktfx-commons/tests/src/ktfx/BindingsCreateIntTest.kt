package ktfx

import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsCreateIntTest {

    @Test fun multipleDependencies() {
        val dependency1 = intProperty(1)
        val dependency2 = intProperty(2)
        val binding = intBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3, binding.value)
        dependency1.value++
        assertEquals(4, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toIntBinding { it?.toMillis()?.toInt() ?: 0 }
        assertEquals(60000, binding.value)
        dependency.value = null
        assertEquals(0, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toIntBinding { if (it) Int.MAX_VALUE else Int.MIN_VALUE }
        assertEquals(Int.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toInt(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toInt(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toIntBinding { it }
        assertEquals(0, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toInt(), binding.value)
    }
}
