package ktfx

import javafx.beans.property.SimpleBooleanProperty
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsWhenTest {

    @Test fun given() {
        assertEquals(0, (given(SimpleBooleanProperty(false)) then 1 otherwise 0).value)
        assertEquals("Hello", (given(SimpleBooleanProperty(true)) then "Hello" otherwise "World").value)
    }
}
