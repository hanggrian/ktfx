package ktfx

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleObjectProperty
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingCreateFloatTest {

    @Test fun multipleDependencies() {
        val dependency1 = SimpleFloatProperty(1f)
        val dependency2 = SimpleFloatProperty(2f)
        val binding = floatBindingOf(dependency1, dependency2) { dependency1.value + dependency2.value }
        assertEquals(3f, binding.value)
        dependency1.value++
        assertEquals(4f, binding.value)
    }

    @Test fun anyDependency() {
        val dependency = SimpleObjectProperty(1.m)
        val binding = dependency.toFloatBinding { it?.toMillis()?.toFloat() ?: 0f }
        assertEquals(60000f, binding.value)
        dependency.clear()
        assertEquals(0f, binding.value)
    }

    @Test fun booleanDependency() {
        val dependency = SimpleBooleanProperty()
        val binding = dependency.toFloatBinding { if (it) Float.MAX_VALUE else Float.MIN_VALUE }
        assertEquals(Float.MIN_VALUE, binding.value)
        dependency.value = true
        assertEquals(Float.MAX_VALUE, binding.value)
    }

    @Test fun doubleDependency() {
        val dependency = SimpleDoubleProperty()
        val binding = dependency.toFloatBinding { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE.toFloat(), binding.value)
    }

    @Test fun floatDependency() {
        val dependency = SimpleFloatProperty()
        val binding = dependency.toFloatBinding { it }
        assertEquals(0f, binding.value)
        dependency.value = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, binding.value)
    }

    @Test fun intDependency() {
        val dependency = SimpleIntegerProperty()
        val binding = dependency.toFloatBinding { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE.toFloat(), binding.value)
    }

    @Test fun longDependency() {
        val dependency = SimpleLongProperty()
        val binding = dependency.toFloatBinding { it.toFloat() }
        assertEquals(0f, binding.value)
        dependency.value = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE.toFloat(), binding.value)
    }
}
