package ktfx.bindings

import javafx.beans.binding.When
import ktfx.booleanPropertyOf
import org.junit.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test fun `when`() {
        assertEquals(0, (When(booleanPropertyOf()) then 1 otherwise 0).value)
        assertEquals("Hello", (When(booleanPropertyOf(true)) then "Hello" otherwise "World").value)
    }
}