package ktfx.bindings

import ktfx.floatPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberValueBindingFloatTest {
    @Test
    fun unaryMinus() = assertEquals(-1f, (-floatPropertyOf(1f)).value)

    @Test
    fun plus() {
        // observable float to double
        assertEquals(3.0, (floatPropertyOf(1f) + 2.0).value)
        assertEquals(3.0, (2.0 + floatPropertyOf(1f)).value)
        // observable float to float
        assertEquals(3f, (floatPropertyOf(1f) + 2f).value)
        assertEquals(3f, (2f + floatPropertyOf(1f)).value)
        // observable float to long
        assertEquals(3f, (floatPropertyOf(1f) + 2L).value)
        assertEquals(3f, (2L + floatPropertyOf(1f)).value)
        // observable float to int
        assertEquals(3f, (floatPropertyOf(1f) + 2).value)
        assertEquals(3f, (2 + floatPropertyOf(1f)).value)
    }

    @Test
    fun minus() {
        // observable float to double
        assertEquals(-1.0, (floatPropertyOf(1f) - 2.0).value)
        assertEquals(1.0, (2.0 - floatPropertyOf(1f)).value)
        // observable float to float
        assertEquals(-1f, (floatPropertyOf(1f) - 2f).value)
        assertEquals(1f, (2f - floatPropertyOf(1f)).value)
        // observable float to long
        assertEquals(-1f, (floatPropertyOf(1f) - 2L).value)
        assertEquals(1f, (2L - floatPropertyOf(1f)).value)
        // observable float to int
        assertEquals(-1f, (floatPropertyOf(1f) - 2).value)
        assertEquals(1f, (2 - floatPropertyOf(1f)).value)
    }

    @Test
    fun times() {
        // observable float to double
        assertEquals(2.0, (floatPropertyOf(1f) * 2.0).value)
        assertEquals(2.0, (2.0 * floatPropertyOf(1f)).value)
        // observable float to float
        assertEquals(2f, (floatPropertyOf(1f) * 2f).value)
        assertEquals(2f, (2f * floatPropertyOf(1f)).value)
        // observable float to long
        assertEquals(2f, (floatPropertyOf(1f) * 2L).value)
        assertEquals(2f, (2L * floatPropertyOf(1f)).value)
        // observable float to int
        assertEquals(2f, (floatPropertyOf(1f) * 2).value)
        assertEquals(2f, (2 * floatPropertyOf(1f)).value)
    }

    @Test
    fun div() {
        // observable float to double
        assertEquals(0.5, (floatPropertyOf(1f) / 2.0).value)
        assertEquals(2.0, (2.0 / floatPropertyOf(1f)).value)
        // observable float to float
        assertEquals(0.5f, (floatPropertyOf(1f) / 2f).value)
        assertEquals(2f, (2f / floatPropertyOf(1f)).value)
        // observable float to long
        assertEquals(0.5f, (floatPropertyOf(1f) / 2L).value)
        assertEquals(2f, (2L / floatPropertyOf(1f)).value)
        // observable float to int
        assertEquals(0.5f, (floatPropertyOf(1f) / 2).value)
        assertEquals(2f, (2 / floatPropertyOf(1f)).value)
    }
}
