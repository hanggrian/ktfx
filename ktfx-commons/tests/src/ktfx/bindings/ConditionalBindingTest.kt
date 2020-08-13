package ktfx.bindings

import ktfx.booleanPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ConditionalBindingTest {

    @Test fun given() {
        assertEquals(0, (given(booleanPropertyOf(false)) then 1 otherwise 0).value)
        assertEquals("Hello", (given(booleanPropertyOf(true)) then "Hello" otherwise "World").value)
    }
}
