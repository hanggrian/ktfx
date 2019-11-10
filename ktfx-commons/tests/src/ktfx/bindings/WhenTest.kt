package ktfx.bindings

import ktfx.booleanProperty
import kotlin.test.Test
import kotlin.test.assertEquals

class WhenTest {

    @Test
    fun given() {
        assertEquals(0, (given(booleanProperty(false)) then 1 otherwise 0).value)
        assertEquals("Hello", (given(booleanProperty(true)) then "Hello" otherwise "World").value)
    }
}