package ktfx.bindings

import ktfx.booleanProperty
import ktfx.doubleProperty
import ktfx.floatProperty
import ktfx.intProperty
import ktfx.longProperty
import ktfx.property
import ktfx.stringProperty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BindingCustomTest {

    @Test fun any() {
        val dependency = property<Person>()
        val binding = dependency.toBinding { it }
        assertNull(binding.value)
        dependency.value = Person("Hendra")
        assertEquals(Person("Hendra"), binding.value)
    }

    @Test fun boolean() {
        val dependency = booleanProperty()
        val binding = dependency.toBooleanBinding { it }
        assertEquals(false, binding.value)
        dependency.value = true
        assertEquals(true, binding.value)
    }

    @Test fun string() {
        val dependency = stringProperty()
        val binding = dependency.toStringBinding { it }
        assertNull(binding.value)
        dependency.value = "Hendra"
        assertEquals("Hendra", binding.value)
    }

    @Test fun double() {
        val dependency = doubleProperty()
        val binding = dependency.toDoubleBinding { it.toDouble() }
        assertEquals(0.0, binding.value)
        dependency.value = 1.0
        assertEquals(1.0, binding.value)
    }

    @Test fun float() {
        val dependency = floatProperty()
        val binding = dependency.toFloatBinding { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = 1f
        assertEquals(1f, binding.value)
    }

    @Test fun int() {
        val dependency = intProperty()
        val binding = dependency.toIntBinding { it.toInt() }
        assertEquals(0, binding.value)
        dependency.value = 1
        assertEquals(1, binding.value)
    }

    @Test fun long() {
        val dependency = longProperty()
        val binding = dependency.toLongBinding { it.toLong() }
        assertEquals(0, binding.value)
        dependency.value = 1
        assertEquals(1, binding.value)
    }

    data class Person(val name: String)
}