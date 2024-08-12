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
import ktfx.time.m
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsBooleanTest {
    @Test
    fun booleanBindingOf() {
        val dependency1 = booleanPropertyOf(true)
        val dependency2 = booleanPropertyOf(true)
        val binding1 =
            booleanBindingOf(dependency1, dependency2) {
                dependency1.value && dependency2.value
            }
        assertTrue(binding1.value)
        dependency1.value = false
        assertFalse(binding1.value)

        val dependency3 = booleanPropertyOf(true)
        val dependency4 = booleanPropertyOf(true)
        val binding2 =
            booleanBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value && dependency4.value
            }
        assertTrue(binding2.value)
        dependency3.value = false
        assertFalse(binding2.value)
    }

    @Test
    fun booleanBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.booleanBindingBy { it.isNotEmpty() }
        assertTrue(binding1.value)
        dependency1.clear()
        assertFalse(binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.booleanBindingBy { it.isNotEmpty() }
        assertTrue(binding2.value)
        dependency2.clear()
        assertFalse(binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.booleanBindingBy { it.isNotEmpty() }
        assertTrue(binding3.value)
        dependency3.clear()
        assertFalse(binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.booleanBindingBy { it == 60.s }
        assertTrue(binding4.value)
        dependency4.value = null
        assertFalse(binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.booleanBindingBy { !it }
        assertTrue(binding5.value)
        dependency5.value = true
        assertFalse(binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.booleanBindingBy { it == 0.0 }
        assertTrue(binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertFalse(binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.booleanBindingBy { it == 0f }
        assertTrue(binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertFalse(binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.booleanBindingBy { it == 0 }
        assertTrue(binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertFalse(binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.booleanBindingBy { it == 0L }
        assertTrue(binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertFalse(binding9.value)
    }
}
