package javafxx.beans.value

import javafx.beans.property.SimpleStringProperty
import org.junit.Test
import kotlin.test.assertEquals

class StringValueTest {
    private val property = SimpleStringProperty("Hello")
    private var value: String by property

    @Test fun accessor() {
        assertEquals(value, "Hello")
        value = "World"
        assertEquals(property.value, "World")
    }
}