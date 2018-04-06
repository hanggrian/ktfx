package ktfx.beans.value

import javafx.beans.property.SimpleBooleanProperty
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BooleanValueTest {
    private val property = SimpleBooleanProperty(false)
    private var value: Boolean by property

    @Test fun accessor() {
        assertFalse(value)
        value = true
        assertTrue(property.value)
    }
}