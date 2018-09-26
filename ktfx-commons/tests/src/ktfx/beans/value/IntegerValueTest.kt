package ktfx.beans.value

import javafx.beans.property.SimpleIntegerProperty
import org.junit.Test
import kotlin.test.assertEquals

class IntegerValueTest {
    private var property = SimpleIntegerProperty(1)
    private var value: Int by property

    @Test fun accessor() {
        assertEquals(value, 1)
        value = 2
        assertEquals(property.value, 2)
    }
}