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
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsIntegerTest {
    @Test
    fun intBindingOf() {
        val dependency1 = intPropertyOf(1)
        val dependency2 = intPropertyOf(2)
        val binding1 =
            intBindingOf(dependency1, dependency2) {
                dependency1.value + dependency2.value
            }
        assertEquals(3, binding1.value)
        dependency1.value++
        assertEquals(4, binding1.value)

        val dependency3 = intPropertyOf(1)
        val dependency4 = intPropertyOf(2)
        val binding2 =
            intBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(3, binding2.value)
        dependency3.value++
        assertEquals(4, binding2.value)
    }

    @Test
    fun intBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.intBindingBy { it.size }
        assertEquals(1, binding1.value)
        dependency1.clear()
        assertEquals(0, binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.intBindingBy { it.size }
        assertEquals(1, binding2.value)
        dependency2.clear()
        assertEquals(0, binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.intBindingBy { it.size }
        assertEquals(1, binding3.value)
        dependency3.clear()
        assertEquals(0, binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.intBindingBy { it?.toMillis()?.toInt() ?: 0 }
        assertEquals(60000, binding4.value)
        dependency4.value = null
        assertEquals(0, binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.intBindingBy { if (it) Int.MAX_VALUE else Int.MIN_VALUE }
        assertEquals(Int.MIN_VALUE, binding5.value)
        dependency5.value = true
        assertEquals(Int.MAX_VALUE, binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.intBindingBy { it.toInt() }
        assertEquals(0, binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toInt(), binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.intBindingBy { it.toInt() }
        assertEquals(0, binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toInt(), binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.intBindingBy { it }
        assertEquals(0, binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.intBindingBy { it.toInt() }
        assertEquals(0, binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toInt(), binding9.value)
    }
}
