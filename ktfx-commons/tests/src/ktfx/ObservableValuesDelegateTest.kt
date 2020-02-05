package ktfx

import com.google.common.truth.Truth.assertThat
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.property.SimpleStringProperty
import javafx.util.Duration
import ktfx.collections.emptyObservableList
import ktfx.collections.emptyObservableMap
import ktfx.collections.emptyObservableSet
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValuesDelegateTest {
    private val anyProperty = SimpleObjectProperty<Duration>()
    private var any by anyProperty

    private val stringProperty = SimpleStringProperty()
    private var string by stringProperty

    private val booleanProperty = SimpleBooleanProperty()
    private var boolean by booleanProperty

    private val doubleProperty = SimpleDoubleProperty()
    private var double by doubleProperty

    private val floatProperty = SimpleFloatProperty()
    private var float by floatProperty

    private val intProperty = SimpleIntegerProperty()
    private var int by intProperty

    private val longProperty = SimpleLongProperty()
    private var long by longProperty

    private val listProperty = SimpleListProperty<String>()
    private var list by listProperty

    private val setProperty = SimpleSetProperty<String>()
    private var set by setProperty

    private val mapProperty = SimpleMapProperty<Int, String>()
    private var map by mapProperty

    @Test fun any() {
        assertNull(any)
        any = 2.m
        assertEquals(2.m, anyProperty.value)
    }

    @Test fun string() {
        assertNull(string)
        string = "Hello World"
        assertEquals("Hello World", stringProperty.value)
    }

    @Test fun boolean() {
        assertFalse(boolean)
        boolean = true
        assertTrue(booleanProperty.value)
    }

    @Test fun double() {
        assertEquals(0.0, double)
        double = Double.MAX_VALUE
        assertEquals(Double.MAX_VALUE, doubleProperty.value)
    }

    @Test fun float() {
        assertEquals(0f, float)
        float = Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, floatProperty.value)
    }

    @Test fun int() {
        assertEquals(0, int)
        int = Int.MAX_VALUE
        assertEquals(Int.MAX_VALUE, intProperty.value)
    }

    @Test fun long() {
        assertEquals(0L, long)
        long = Long.MAX_VALUE
        assertEquals(Long.MAX_VALUE, longProperty.value)
    }

    @Test fun list() {
        assertNull(list)
        list = emptyObservableList()
        assertThat(listProperty.value).isEmpty()
    }

    @Test fun set() {
        assertNull(set)
        set = emptyObservableSet()
        assertThat(setProperty.value).isEmpty()
    }

    @Test fun map() {
        assertNull(map)
        map = emptyObservableMap()
        assertThat(mapProperty.value.keys).isEmpty()
    }
}
