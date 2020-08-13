package ktfx.bindings

import ktfx.longPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberBindingLongTest {

    @Test fun unaryMinus() = assertEquals(-1L, (-longPropertyOf(1L)).value)

    @Test fun plus() {
        // observable long to double
        assertEquals(3.0, (longPropertyOf(1L) + 2.0).value)
        assertEquals(3.0, (2.0 + longPropertyOf(1L)).value)
        // observable long to float
        assertEquals(3f, (longPropertyOf(1L) + 2f).value)
        assertEquals(3f, (2f + longPropertyOf(1L)).value)
        // observable long to long
        assertEquals(3L, (longPropertyOf(1L) + 2L).value)
        assertEquals(3L, (2L + longPropertyOf(1L)).value)
        // observable long to int
        assertEquals(3L, (longPropertyOf(1L) + 2).value)
        assertEquals(3L, (2 + longPropertyOf(1L)).value)
    }

    @Test fun minus() {
        // observable long to double
        assertEquals(-1.0, (longPropertyOf(1L) - 2.0).value)
        assertEquals(1.0, (2.0 - longPropertyOf(1L)).value)
        // observable long to float
        assertEquals(-1f, (longPropertyOf(1L) - 2f).value)
        assertEquals(1f, (2f - longPropertyOf(1L)).value)
        // observable long to long
        assertEquals(-1L, (longPropertyOf(1L) - 2L).value)
        assertEquals(1L, (2L - longPropertyOf(1L)).value)
        // observable long to int
        assertEquals(-1L, (longPropertyOf(1L) - 2).value)
        assertEquals(1L, (2 - longPropertyOf(1L)).value)
    }

    @Test fun times() {
        // observable long to double
        assertEquals(2.0, (longPropertyOf(1L) * 2.0).value)
        assertEquals(2.0, (2.0 * longPropertyOf(1L)).value)
        // observable long to float
        assertEquals(2f, (longPropertyOf(1L) * 2f).value)
        assertEquals(2f, (2f * longPropertyOf(1L)).value)
        // observable long to long
        assertEquals(2L, (longPropertyOf(1L) * 2L).value)
        assertEquals(2L, (2L * longPropertyOf(1L)).value)
        // observable long to int
        assertEquals(2L, (longPropertyOf(1L) * 2).value)
        assertEquals(2L, (2 * longPropertyOf(1L)).value)
    }

    @Test fun div() {
        // observable long to double
        assertEquals(0.5, (longPropertyOf(1L) / 2.0).value)
        assertEquals(2.0, (2.0 / longPropertyOf(1L)).value)
        // observable long to float
        assertEquals(0.5f, (longPropertyOf(1L) / 2f).value)
        assertEquals(2f, (2f / longPropertyOf(1L)).value)
        // observable long to long
        assertEquals(0L, (longPropertyOf(1L) / 2L).value)
        assertEquals(2L, (2L / longPropertyOf(1L)).value)
        // observable long to int
        assertEquals(0L, (longPropertyOf(1L) / 2).value)
        assertEquals(2L, (2 / longPropertyOf(1L)).value)
    }
}
