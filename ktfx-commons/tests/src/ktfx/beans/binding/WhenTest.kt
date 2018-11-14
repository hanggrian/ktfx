package ktfx.beans.binding

import javafx.beans.binding.When
import ktfx.beans.property.asProperty
import org.junit.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test fun `when`() {
        assertEquals(0, (When(false.asProperty()) then 1 otherwise 0).value)
        assertEquals("Hello", (When(true.asProperty()) then "Hello" otherwise "World").value)
    }
}