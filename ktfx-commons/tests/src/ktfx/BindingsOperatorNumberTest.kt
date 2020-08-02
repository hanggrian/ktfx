package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals

class BindingsOperatorNumberTest {

    @Test fun plus() {
        assertEquals(3.0, (1.0 + intProperty(2)).value)
        assertEquals(3f, (1f + intProperty(2)).value)
        assertEquals(3, (1L + intProperty(2)).value)
        assertEquals(3, (1 + intProperty(2)).value)
    }

    @Test fun minus() {
        assertEquals(3.0, (5.0 - intProperty(2)).value)
        assertEquals(3f, (5f - intProperty(2)).value)
        assertEquals(3, (5L - intProperty(2)).value)
        assertEquals(3, (5 - intProperty(2)).value)
    }

    @Test fun times() {
        assertEquals(6.0, (3.0 * intProperty(2)).value)
        assertEquals(6f, (3f * intProperty(2)).value)
        assertEquals(6, (3L * intProperty(2)).value)
        assertEquals(6, (3 * intProperty(2)).value)
    }

    @Test fun div() {
        assertEquals(2.0, (4.0 / intProperty(2)).value)
        assertEquals(2f, (4f / intProperty(2)).value)
        assertEquals(2, (4L / intProperty(2)).value)
        assertEquals(2, (4 / intProperty(2)).value)
    }
}
