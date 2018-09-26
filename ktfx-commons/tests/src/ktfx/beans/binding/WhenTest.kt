package ktfx.beans.binding

import ktfx.beans.property.toProperty
import org.junit.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test fun `when`() {
        assertEquals(0, (`when`(false.toProperty()) then 1 otherwise 0).value)
        assertEquals("Hello", (`when`(true.toProperty()) then "Hello" otherwise "World").value)
    }
}