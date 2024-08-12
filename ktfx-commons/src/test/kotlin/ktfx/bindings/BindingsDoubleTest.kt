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

class BindingsDoubleTest {
    @Test
    fun doubleBindingOf() {
        val dependency1 = doublePropertyOf(1.0)
        val dependency2 = doublePropertyOf(2.0)
        val binding1 =
            doubleBindingOf(dependency1, dependency2) {
                dependency1.value + dependency2.value
            }
        assertEquals(3.0, binding1.value)
        dependency1.value++
        assertEquals(4.0, binding1.value)

        val dependency3 = doublePropertyOf(1.0)
        val dependency4 = doublePropertyOf(2.0)
        val binding2 =
            doubleBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(3.0, binding2.value)
        dependency3.value++
        assertEquals(4.0, binding2.value)
    }

    @Test
    fun doubleBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.doubleBindingBy { it.size.toDouble() }
        assertEquals(1.0, binding1.value)
        dependency1.clear()
        assertEquals(0.0, binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.doubleBindingBy { it.size.toDouble() }
        assertEquals(1.0, binding2.value)
        dependency2.clear()
        assertEquals(0.0, binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.doubleBindingBy { it.size.toDouble() }
        assertEquals(1.0, binding3.value)
        dependency3.clear()
        assertEquals(0.0, binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.doubleBindingBy { it?.toMillis() ?: 0.0 }
        assertEquals(60000.0, binding4.value)
        dependency4.value = null
        assertEquals(0.0, binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 =
            dependency5.doubleBindingBy { if (it) Double.MAX_VALUE else Double.MIN_VALUE }
        assertEquals(Double.MIN_VALUE, binding5.value)
        dependency5.value = true
        assertEquals(Double.MAX_VALUE, binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.doubleBindingBy { it }
        assertEquals(0.0, binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.doubleBindingBy { it.toDouble() }
        assertEquals(0.0, binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble(), binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.doubleBindingBy { it.toDouble() }
        assertEquals(0.0, binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toDouble(), binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.doubleBindingBy { it.toDouble() }
        assertEquals(0.0, binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toDouble(), binding9.value)
    }
}
