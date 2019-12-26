package ktfx

import com.google.common.truth.Truth.assertThat
import javafx.util.Duration
import ktfx.collections.emptyObservableList
import ktfx.collections.emptyObservableMap
import ktfx.collections.emptyObservableSet
import ktfx.util.minutes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableValueDelegateTest {
    private val anyProperty = propertyOf<Duration>()
    private var any by anyProperty

    private val stringProperty = stringPropertyOf()
    private var string by stringProperty

    private val booleanProperty = booleanPropertyOf()
    private var boolean by booleanProperty

    private val doubleProperty = doublePropertyOf()
    private var double by doubleProperty

    private val floatProperty = floatPropertyOf()
    private var float by floatProperty

    private val intProperty = intPropertyOf()
    private var int by intProperty

    private val longProperty = longPropertyOf()
    private var long by longProperty

    private val listProperty = listPropertyOf<String>()
    private var list by listProperty

    private val setProperty = setPropertyOf<String>()
    private var set by setProperty

    private val mapProperty = mapPropertyOf<Int, String>()
    private var map by mapProperty

    @Test fun any() {
        assertNull(any)
        any = 2.minutes
        assertEquals(2.minutes, anyProperty.value)
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
