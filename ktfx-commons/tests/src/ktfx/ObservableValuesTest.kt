package ktfx

import javafx.beans.property.SimpleStringProperty
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValuesTest {

    @Test fun hasValue() {
        val property = SimpleStringProperty()
        assertFalse(property.hasValue())
        property.value = "Hello World"
        assertTrue(property.hasValue())
    }

    @Test fun clear() {
        val property = SimpleStringProperty("Hello World")
        assertTrue(property.hasValue())
        property.clear()
        assertFalse(property.hasValue())
    }
}
