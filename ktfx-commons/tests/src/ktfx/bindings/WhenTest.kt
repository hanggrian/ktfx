package ktfx.bindings

import javafx.beans.binding.When
import ktfx.boolean
import org.junit.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test fun `when`() {
        assertEquals(0, (When(boolean()) then 1 otherwise 0).value)
        assertEquals("Hello", (When(boolean(true)) then "Hello" otherwise "World").value)
    }
}