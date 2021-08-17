package ktfx.bindings

import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberValueBindingIntegerTest {

    @Test
    fun unaryMinus() = assertEquals(-1, (-intPropertyOf(1)).value)

    @Test
    fun plus() {
        // observable int to double
        assertEquals(3.0, (intPropertyOf(1) + 2.0).value)
        assertEquals(3.0, (2.0 + intPropertyOf(1)).value)
        // observable int to float
        assertEquals(3f, (intPropertyOf(1) + 2f).value)
        assertEquals(3f, (2f + intPropertyOf(1)).value)
        // observable int to long
        assertEquals(3L, (intPropertyOf(1) + 2L).value)
        assertEquals(3L, (2L + intPropertyOf(1)).value)
        // observable int to int
        assertEquals(3, (intPropertyOf(1) + 2).value)
        assertEquals(3, (2 + intPropertyOf(1)).value)
    }

    @Test
    fun minus() {
        // observable int to double
        assertEquals(-1.0, (intPropertyOf(1) - 2.0).value)
        assertEquals(1.0, (2.0 - intPropertyOf(1)).value)
        // observable int to float
        assertEquals(-1f, (intPropertyOf(1) - 2f).value)
        assertEquals(1f, (2f - intPropertyOf(1)).value)
        // observable int to long
        assertEquals(-1L, (intPropertyOf(1) - 2L).value)
        assertEquals(1L, (2L - intPropertyOf(1)).value)
        // observable int to int
        assertEquals(-1, (intPropertyOf(1) - 2).value)
        assertEquals(1, (2 - intPropertyOf(1)).value)
    }

    @Test
    fun times() {
        // observable int to double
        assertEquals(2.0, (intPropertyOf(1) * 2.0).value)
        assertEquals(2.0, (2.0 * intPropertyOf(1)).value)
        // observable int to float
        assertEquals(2f, (intPropertyOf(1) * 2f).value)
        assertEquals(2f, (2f * intPropertyOf(1)).value)
        // observable int to long
        assertEquals(2L, (intPropertyOf(1) * 2L).value)
        assertEquals(2L, (2L * intPropertyOf(1)).value)
        // observable int to int
        assertEquals(2, (intPropertyOf(1) * 2).value)
        assertEquals(2, (2 * intPropertyOf(1)).value)
    }

    @Test
    fun div() {
        // observable int to double
        assertEquals(0.5, (intPropertyOf(1) / 2.0).value)
        assertEquals(2.0, (2.0 / intPropertyOf(1)).value)
        // observable int to float
        assertEquals(0.5f, (intPropertyOf(1) / 2f).value)
        assertEquals(2f, (2f / intPropertyOf(1)).value)
        // observable int to long
        assertEquals(0L, (intPropertyOf(1) / 2L).value)
        assertEquals(2L, (2L / intPropertyOf(1)).value)
        // observable int to int
        assertEquals(0, (intPropertyOf(1) / 2).value)
        assertEquals(2, (2 / intPropertyOf(1)).value)
    }
}
