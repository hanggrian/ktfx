package ktfx.bindings

import ktfx.booleanPropertyOf
import ktfx.collections.mutableObservableListOf
import ktfx.collections.mutableObservableMapOf
import ktfx.collections.mutableObservableSetOf
import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import ktfx.propertyOf
import ktfx.time.minutes
import ktfx.time.seconds
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsBooleanTest {

    @Test
    fun multipleDependencies() {
        val dependency1 = booleanPropertyOf(true)
        val dependency2 = booleanPropertyOf(true)
        val binding1 = booleanBindingOf(dependency1, dependency2) { dependency1.value && dependency2.value }
        assertTrue(binding1.value)
        dependency1.value = false
        assertFalse(binding1.value)

        val dependency3 = booleanPropertyOf(true)
        val dependency4 = booleanPropertyOf(true)
        val binding2 = booleanBindingOf(listOf(dependency3, dependency4)) { dependency3.value && dependency4.value }
        assertTrue(binding2.value)
        dependency3.value = false
        assertFalse(binding2.value)
    }

    @Test
    fun listDependency() {
        val dependency = mutableObservableListOf(1.minutes)
        val binding = dependency.asBoolean { it.isNotEmpty() }
        assertTrue(binding.value)
        dependency.clear()
        assertFalse(binding.value)
    }

    @Test
    fun setDependency() {
        val dependency = mutableObservableSetOf(1.minutes)
        val binding = dependency.asBoolean { it.isNotEmpty() }
        assertTrue(binding.value)
        dependency.clear()
        assertFalse(binding.value)
    }

    @Test
    fun mapDependency() {
        val dependency = mutableObservableMapOf(1.minutes to 2.minutes)
        val binding = dependency.asBoolean { it.isNotEmpty() }
        assertTrue(binding.value)
        dependency.clear()
        assertFalse(binding.value)
    }

    @Test
    fun anyDependency() {
        val dependency = propertyOf(1.minutes)
        val binding = dependency.asBoolean { it == 60.seconds }
        assertTrue(binding.value)
        dependency.value = null
        assertFalse(binding.value)
    }

    @Test
    fun booleanDependency() {
        val dependency = booleanPropertyOf()
        val binding = dependency.asBoolean { !it }
        assertTrue(binding.value)
        dependency.value = true
        assertFalse(binding.value)
    }

    @Test
    fun doubleDependency() {
        val dependency = doublePropertyOf()
        val binding = dependency.asBoolean { it == 0.0 }
        assertTrue(binding.value)
        dependency.value = Double.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test
    fun floatDependency() {
        val dependency = floatPropertyOf()
        val binding = dependency.asBoolean { it == 0f }
        assertTrue(binding.value)
        dependency.value = Float.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test
    fun intDependency() {
        val dependency = intPropertyOf()
        val binding = dependency.asBoolean { it == 0 }
        assertTrue(binding.value)
        dependency.value = Int.MAX_VALUE
        assertFalse(binding.value)
    }

    @Test
    fun longDependency() {
        val dependency = longPropertyOf()
        val binding = dependency.asBoolean { it == 0L }
        assertTrue(binding.value)
        dependency.value = Long.MAX_VALUE
        assertFalse(binding.value)
    }
}
