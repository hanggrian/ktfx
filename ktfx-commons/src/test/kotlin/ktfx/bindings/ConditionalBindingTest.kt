package ktfx.bindings

import javafx.util.Duration.ZERO
import ktfx.booleanPropertyOf
import ktfx.intPropertyOf
import ktfx.propertyOf
import ktfx.stringPropertyOf
import ktfx.time.ms
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ConditionalBindingTest {
    @Test
    fun given() {
        assertEquals(
            0,
            (
                given(booleanPropertyOf(false)) then
                    intPropertyOf(1) otherwise
                    intPropertyOf(0)
            ).value,
        )
        assertEquals(0, (given(booleanPropertyOf(false)) then 1 otherwise 0).value)
        assertEquals(0.0, (given(booleanPropertyOf(false)) then 1.0 otherwise 0.0).value)
        assertEquals(0f, (given(booleanPropertyOf(false)) then 1f otherwise 0f).value)
        assertEquals(0L, (given(booleanPropertyOf(false)) then 1L otherwise 0L).value)

        assertFalse(
            (
                given(booleanPropertyOf(false)) then
                    booleanPropertyOf(true) otherwise
                    booleanPropertyOf(false)
            ).value,
        )
        assertFalse((given(booleanPropertyOf(false)) then true otherwise false).value)

        assertEquals(
            ZERO,
            (
                given(booleanPropertyOf(false)) then
                    propertyOf(1.s) otherwise
                    propertyOf(ZERO)
            ).value,
        )
        assertEquals(ZERO, (given(booleanPropertyOf(false)) then 1.ms otherwise ZERO).value)

        assertEquals(
            "World",
            (
                given(booleanPropertyOf(false)) then
                    stringPropertyOf("Hello") otherwise
                    stringPropertyOf("World")
            ).value,
        )
        assertEquals(
            "World",
            (given(booleanPropertyOf(false)) then "Hello" otherwise "World").value,
        )
    }
}
