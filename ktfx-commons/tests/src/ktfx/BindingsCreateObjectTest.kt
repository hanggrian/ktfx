package ktfx

import javafx.util.Duration
import ktfx.time.m
import ktfx.time.plus
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingsCreateObjectTest {

    @Test fun nullability() {
        val dependency = property<String>()
        val binding = bindingOf<String>(dependency) { null }
        assertNull(binding.get())
    }

    @Test fun multipleDependencies() {
        val dependency1 = property(1.m)
        val dependency2 = property(30.s)
        val binding = bindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(90.s, binding.value)
        dependency1.value = 15.s
        assertEquals(45.s, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = property(1.m)
        val binding = dependency.toBinding { it }
        assertEquals(60.s, binding.value)
        dependency.value = null
        assertNull(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanProperty()
        val binding = dependency.toBinding { if (it) 1.s else 2.s }
        assertEquals(2.s, binding.value)
        dependency.value = true
        assertEquals(1.s, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doubleProperty()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.s, binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatProperty()
        val binding = dependency.toBinding<Duration> { it.toDouble().s }
        assertEquals(0.s, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble().s, binding.value)
    }

    @Test fun intDependency() {
        val dependency = intProperty()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.s, binding.value)
    }

    @Test fun longDependency() {
        val dependency = longProperty()
        val binding = dependency.toBinding<Duration> { it.s }
        assertEquals(0.s, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.s, binding.value)
    }
}
