package ktfx

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsCreateStringTest {

    @Test fun multipleDependencies() {
        val dependency1 = SimpleStringProperty("Hello")
        val dependency2 = SimpleStringProperty("World")
        val binding = stringBindingOf(dependency1, dependency2) { dependency1.value + ' ' + dependency2.value }
        assertEquals("Hello World", binding.value)
        dependency1.value = "Goodbye"
        assertEquals("Goodbye World", binding.value)
    }

    @Test fun anyDependency() {
        val dependency = SimpleObjectProperty(1.m)
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("60000.0 ms", binding.value)
        dependency.clear()
        assertEquals("null", binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = SimpleBooleanProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("false", binding.value)
        dependency.value = true
        assertEquals("true", binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = SimpleDoubleProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toString(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = SimpleFloatProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0.0", binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE.toString(), binding.value)
    }

    @Test fun intDependency() {
        val dependency = SimpleIntegerProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toString(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = SimpleLongProperty()
        val binding = dependency.toStringBinding { it.toString() }
        assertEquals("0", binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toString(), binding.value)
    }
}
