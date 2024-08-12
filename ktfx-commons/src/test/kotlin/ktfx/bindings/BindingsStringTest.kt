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
import ktfx.stringPropertyOf
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsStringTest {
    @Test
    fun stringPropertyOf() {
        val dependency1 = stringPropertyOf("Hello")
        val dependency2 = stringPropertyOf("World")
        val binding1 =
            stringBindingOf(dependency1, dependency2) {
                dependency1.value + ' ' + dependency2.value
            }
        assertEquals("Hello World", binding1.value)
        dependency1.value = "Goodbye"
        assertEquals("Goodbye World", binding1.value)

        val dependency3 = stringPropertyOf("Hello")
        val dependency4 = stringPropertyOf("World")
        val binding2 =
            stringBindingOf(listOf(dependency3, dependency4)) {
                dependency3.value + ' ' + dependency4.value
            }
        assertEquals("Hello World", binding2.value)
        dependency3.value = "Goodbye"
        assertEquals("Goodbye World", binding2.value)
    }

    @Test
    fun stringBindingBy() {
        val dependency1 = mutableObservableListOf(1.m)
        val binding1 = dependency1.stringBindingBy { it.toString() }
        assertEquals("[60000.0 ms]", binding1.value)
        dependency1.clear()
        assertEquals("[]", binding1.value)

        val dependency2 = mutableObservableSetOf(1.m)
        val binding2 = dependency2.stringBindingBy { it.toString() }
        assertEquals("[60000.0 ms]", binding2.value)
        dependency2.clear()
        assertEquals("[]", binding2.value)

        val dependency3 = mutableObservableMapOf(1.m to 2.m)
        val binding3 = dependency3.stringBindingBy { it.toString() }
        assertEquals("{60000.0 ms=120000.0 ms}", binding3.value)
        dependency3.clear()
        assertEquals("{}", binding3.value)

        val dependency4 = propertyOf(1.m)
        val binding4 = dependency4.stringBindingBy { it.toString() }
        assertEquals("60000.0 ms", binding4.value)
        dependency4.value = null
        assertEquals("null", binding4.value)

        val dependency5 = booleanPropertyOf()
        val binding5 = dependency5.stringBindingBy { it.toString() }
        assertEquals("false", binding5.value)
        dependency5.value = true
        assertEquals("true", binding5.value)

        val dependency6 = doublePropertyOf()
        val binding6 = dependency6.stringBindingBy { it.toString() }
        assertEquals("0.0", binding6.value)
        dependency6.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toString(), binding6.value)

        val dependency7 = floatPropertyOf()
        val binding7 = dependency7.stringBindingBy { it.toString() }
        assertEquals("0.0", binding7.value)
        dependency7.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toString(), binding7.value)

        val dependency8 = intPropertyOf()
        val binding8 = dependency8.stringBindingBy { it.toString() }
        assertEquals("0", binding8.value)
        dependency8.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toString(), binding8.value)

        val dependency9 = longPropertyOf()
        val binding9 = dependency9.stringBindingBy { it.toString() }
        assertEquals("0", binding9.value)
        dependency9.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toString(), binding9.value)
    }
}
