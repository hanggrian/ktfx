package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingCreateTest {

    @Test fun any() {
        val dependency = propertyOf<Person>()
        val binding = dependency.toBinding { it }
        assertNull(binding.value)
        dependency.value = Person("Hendra")
        assertEquals(Person("Hendra"), binding.value)
    }

    @Test fun boolean() {
        val dependency = booleanPropertyOf()
        val binding = dependency.toBooleanBinding { it }
        assertEquals(false, binding.value)
        dependency.value = true
        assertEquals(true, binding.value)
    }

    @Test fun string() {
        val dependency = stringPropertyOf()
        val binding = dependency.toStringBinding { it }
        assertNull(binding.value)
        dependency.value = "Hendra"
        assertEquals("Hendra", binding.value)
    }

    @Test fun double() {
        val dependency = doublePropertyOf()
        val binding = dependency.toDoubleBinding { it }
        assertEquals(0.0, binding.value)
        dependency.value = 1.0
        assertEquals(1.0, binding.value)
    }

    @Test fun float() {
        val dependency = floatPropertyOf()
        val binding = dependency.toFloatBinding { it }
        assertEquals(0f, binding.value)
        dependency.value = 1f
        assertEquals(1f, binding.value)
    }

    @Test fun int() {
        val dependency = intPropertyOf()
        val binding = dependency.toIntBinding { it }
        assertEquals(0, binding.value)
        dependency.value = 1
        assertEquals(1, binding.value)
    }

    @Test fun long() {
        val dependency = longPropertyOf()
        val binding = dependency.toLongBinding { it }
        assertEquals(0, binding.value)
        dependency.value = 1
        assertEquals(1, binding.value)
    }

    data class Person(val name: String)
}