package ktfx

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import ktfx.util.minutes
import ktfx.util.plus
import ktfx.util.seconds

class BindingCreateObjectTest {

    @Test fun multipleDependencies() {
        val dependency1 = propertyOf(1.minutes)
        val dependency2 = propertyOf(30.seconds)
        val binding = bindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(90.seconds, binding.value)
        dependency1.value = 15.seconds
        assertEquals(45.seconds, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.toBinding { it }
        assertEquals(60.seconds, binding.value)
        dependency.clear()
        assertNull(binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toBinding { if (it) 1.seconds else 2.seconds }
        assertEquals(2.seconds, binding.value)
        dependency.value = true
        assertEquals(1.seconds, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.toBinding<Duration> { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.seconds, binding.value)
    }

    @Test fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.toBinding<Duration> { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.seconds, binding.value)
    }

    @Test fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.toBinding<Duration> { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.seconds, binding.value)
    }

    @Test fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.toBinding<Duration> { it.seconds }
        assertEquals(0.seconds, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.seconds, binding.value)
    }
}
