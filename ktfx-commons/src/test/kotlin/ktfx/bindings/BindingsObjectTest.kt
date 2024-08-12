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
import ktfx.time.plus
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingsObjectTest {
    @Test
    fun `Provide null value`() {
        val dependency = propertyOf<String>()
        val binding = bindingOf<String>(dependency) { null }
        assertNull(binding.get())
    }

    @Test
    fun bindingOf() {
        val dependency1 = propertyOf(1.m)
        val dependency2 = propertyOf(30.s)
        val binding1 = bindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(90.s, binding1.value)
        dependency1.value = 15.s
        assertEquals(45.s, binding1.value)

        val dependency3 = propertyOf(1.m)
        val dependency4 = propertyOf(30.s)
        val binding2 =
            bindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + dependency4.value
            }
        assertEquals(90.s, binding2.value)
        dependency3.value = 15.s
        assertEquals(45.s, binding2.value)
    }

    @Test
    fun bindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.bindingBy { it.firstOrNull() }
        assertEquals(1.m, binding1.value)
        dependency1.clear()
        assertNull(binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.bindingBy { it.firstOrNull() }
        assertEquals(1.m, binding2.value)
        dependency2.clear()
        assertNull(binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.bindingBy { it.keys.firstOrNull() }
        assertEquals(1.m, binding3.value)
        dependency3.clear()
        assertNull(binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.bindingBy { it }
        assertEquals(60.s, binding4.value)
        dependency4.value = null
        assertNull(binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.bindingBy { if (it) 1.s else 2.s }
        assertEquals(2.s, binding5.value)
        dependency5.value = true
        assertEquals(1.s, binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.bindingBy { it.s }
        assertEquals(0.s, binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.s, binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.bindingBy { it.toDouble().s }
        assertEquals(0.s, binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toDouble().s, binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.bindingBy { it.s }
        assertEquals(0.s, binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.s, binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.bindingBy { it.s }
        assertEquals(0.s, binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.s, binding9.value)
    }
}
