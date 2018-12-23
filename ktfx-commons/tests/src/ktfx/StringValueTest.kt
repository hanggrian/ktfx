package ktfx

import javafx.beans.property.SimpleStringProperty
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringValueTest {

    private val property = SimpleStringProperty("Hello")
    private var value: String by property

    private val emptyProperty = SimpleStringProperty()

    @Test fun accessor() {
        assertEquals(value, "Hello")
        value = "World"
        assertEquals(value, "World")
    }

    @Test fun isNullOrBlank() {
        assertFalse(property.isNullOrBlank().get())
        assertTrue(emptyProperty.isNullOrBlank().get())
    }

    @Test fun isNullOrEmpty() {
        assertFalse(property.isNullOrEmpty().get())
        assertTrue(emptyProperty.isNullOrEmpty().get())
    }

    @Test fun orEmpty() {
        assertEquals("Hello", property.orEmpty().get())
        assertEquals("", emptyProperty.orEmpty().get())
    }

    @Test fun indices() = assertEquals(IntRange(0, 4), property.indices.get())

    @Test fun lastIndex() = assertEquals(4, property.lastIndex.get())
}