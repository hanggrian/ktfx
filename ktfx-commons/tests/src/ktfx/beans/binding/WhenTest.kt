package ktfx.beans.binding

import javafx.beans.binding.When
import ktfx.beans.property.toProperty
import org.junit.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test fun `when`() {
        assertEquals(0, (When(false.toProperty()) then 1 otherwise 0).value)
        assertEquals("Hello", (When(true.toProperty()) then "Hello" otherwise "World").value)
    }
}