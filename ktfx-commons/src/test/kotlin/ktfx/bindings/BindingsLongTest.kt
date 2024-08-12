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

class BindingsLongTest {
    @Test
    fun longBindingOf() {
        val dependency1 = longPropertyOf(1)
        val dependency2 = longPropertyOf(2)
        val binding1 =
            longBindingOf(dependency1, dependency2) {
                dependency1.value + dependency2.value
            }
        assertEquals(3, binding1.value)
        dependency1.value++
        assertEquals(4, binding1.value)

        val dependency3 = longPropertyOf(1)
        val dependency4 = longPropertyOf(2)
        val binding2 =
            longBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(3, binding2.value)
        dependency3.value++
        assertEquals(4, binding2.value)
    }

    @Test
    fun longBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.longBindingBy { it.size.toLong() }
        assertEquals(1L, binding1.value)
        dependency1.clear()
        assertEquals(0L, binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.longBindingBy { it.size.toLong() }
        assertEquals(1L, binding2.value)
        dependency2.clear()
        assertEquals(0L, binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.longBindingBy { it.size.toLong() }
        assertEquals(1L, binding3.value)
        dependency3.clear()
        assertEquals(0L, binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.longBindingBy { it?.toMillis()?.toLong() ?: 0 }
        assertEquals(60000, binding4.value)
        dependency4.value = null
        assertEquals(0, binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.longBindingBy { if (it) Long.MAX_VALUE else Long.MIN_VALUE }
        assertEquals(Long.MIN_VALUE, binding5.value)
        dependency5.value = true
        assertEquals(Long.MAX_VALUE, binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.longBindingBy { it.toLong() }
        assertEquals(0, binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toLong(), binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.longBindingBy { it.toLong() }
        assertEquals(0, binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toLong(), binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.longBindingBy { it.toLong() }
        assertEquals(0, binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toLong(), binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.longBindingBy { it }
        assertEquals(0, binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, binding9.value)
    }
}
