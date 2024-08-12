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

class BindingsFloatTest {
    @Test
    fun floatBindingOf() {
        val dependency1 = floatPropertyOf(1f)
        val dependency2 = floatPropertyOf(2f)
        val binding1 =
            floatBindingOf(dependency1, dependency2) {
                dependency1.value + dependency2.value
            }
        assertEquals(3f, binding1.value)
        dependency1.value++
        assertEquals(4f, binding1.value)

        val dependency3 = floatPropertyOf(1f)
        val dependency4 = floatPropertyOf(2f)
        val binding2 =
            floatBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(3f, binding2.value)
        dependency3.value++
        assertEquals(4f, binding2.value)
    }

    @Test
    fun floatBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.floatBindingBy { it.size.toFloat() }
        assertEquals(1f, binding1.value)
        dependency1.clear()
        assertEquals(0f, binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.floatBindingBy { it.size.toFloat() }
        assertEquals(1f, binding2.value)
        dependency2.clear()
        assertEquals(0f, binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.floatBindingBy { it.size.toFloat() }
        assertEquals(1f, binding3.value)
        dependency3.clear()
        assertEquals(0f, binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.floatBindingBy { it?.toMillis()?.toFloat() ?: 0f }
        assertEquals(60000f, binding4.value)
        dependency4.value = null
        assertEquals(0f, binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.floatBindingBy { if (it) Float.MAX_VALUE else Float.MIN_VALUE }
        assertEquals(Float.MIN_VALUE, binding5.value)
        dependency5.value = true
        assertEquals(Float.MAX_VALUE, binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.floatBindingBy { it.toFloat() }
        assertEquals(0f, binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toFloat(), binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.floatBindingBy { it }
        assertEquals(0f, binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.floatBindingBy { it.toFloat() }
        assertEquals(0f, binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toFloat(), binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.floatBindingBy { it.toFloat() }
        assertEquals(0f, binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toFloat(), binding9.value)
    }
}
