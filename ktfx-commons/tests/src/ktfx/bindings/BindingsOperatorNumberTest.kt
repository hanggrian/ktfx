package ktfx.bindings

import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsOperatorNumberTest {

    @Test fun plus() {
        assertEquals(3.0, (1.0 + intPropertyOf(2)).value)
        assertEquals(3f, (1f + intPropertyOf(2)).value)
        assertEquals(3, (1L + intPropertyOf(2)).value)
        assertEquals(3, (1 + intPropertyOf(2)).value)
    }

    @Test fun minus() {
        assertEquals(3.0, (5.0 - intPropertyOf(2)).value)
        assertEquals(3f, (5f - intPropertyOf(2)).value)
        assertEquals(3, (5L - intPropertyOf(2)).value)
        assertEquals(3, (5 - intPropertyOf(2)).value)
    }

    @Test fun times() {
        assertEquals(6.0, (3.0 * intPropertyOf(2)).value)
        assertEquals(6f, (3f * intPropertyOf(2)).value)
        assertEquals(6, (3L * intPropertyOf(2)).value)
        assertEquals(6, (3 * intPropertyOf(2)).value)
    }

    @Test fun div() {
        assertEquals(2.0, (4.0 / intPropertyOf(2)).value)
        assertEquals(2f, (4f / intPropertyOf(2)).value)
        assertEquals(2, (4L / intPropertyOf(2)).value)
        assertEquals(2, (4 / intPropertyOf(2)).value)
    }
}
