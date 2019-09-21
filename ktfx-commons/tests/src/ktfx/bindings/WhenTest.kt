package ktfx.bindings

import javafx.beans.binding.When
import ktfx.asProperty
import kotlin.test.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test
    fun `when`() {
        assertEquals(0, (When(false.asProperty()) then 1 otherwise 0).value)
        assertEquals("Hello", (When(true.asProperty()) then "Hello" otherwise "World").value)
    }
}