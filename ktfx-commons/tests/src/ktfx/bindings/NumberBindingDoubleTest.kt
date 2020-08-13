package ktfx.bindings

import ktfx.doublePropertyOf
import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumberBindingDoubleTest {

    @Test fun unaryMinus() = assertEquals(-1.0, (-doublePropertyOf(1.0)).value)

    @Test fun plus() {
        // observable double to observable number
        assertEquals(3.0, (doublePropertyOf(1.0) + doublePropertyOf(2.0)).value)
        // observable double to double
        assertEquals(3.0, (doublePropertyOf(1.0) + 2.0).value)
        assertEquals(3.0, (2.0 + doublePropertyOf(1.0)).value)
        // observable double to float
        assertEquals(3.0, (doublePropertyOf(1.0) + 2f).value)
        assertEquals(3.0, (2f + doublePropertyOf(1.0)).value)
        // observable double to long
        assertEquals(3.0, (doublePropertyOf(1.0) + 2L).value)
        assertEquals(3.0, (2L + doublePropertyOf(1.0)).value)
        // observable double to int
        assertEquals(3.0, (doublePropertyOf(1.0) + 2).value)
        assertEquals(3.0, (2 + doublePropertyOf(1.0)).value)
    }

    @Test fun minus() {
        // observable double to observable number
        assertEquals(-1.0, (doublePropertyOf(1.0) - doublePropertyOf(2.0)).value)
        // observable double to double
        assertEquals(-1.0, (doublePropertyOf(1.0) - 2.0).value)
        assertEquals(1.0, (2.0 - doublePropertyOf(1.0)).value)
        // observable double to float
        assertEquals(-1.0, (doublePropertyOf(1.0) - 2f).value)
        assertEquals(1.0, (2f - doublePropertyOf(1.0)).value)
        // observable double to long
        assertEquals(-1.0, (doublePropertyOf(1.0) - 2L).value)
        assertEquals(1.0, (2L - doublePropertyOf(1.0)).value)
        // observable double to int
        assertEquals(-1.0, (doublePropertyOf(1.0) - 2).value)
        assertEquals(1.0, (2 - doublePropertyOf(1.0)).value)
    }

    @Test fun times() {
        // observable double to observable number
        assertEquals(2.0, (doublePropertyOf(1.0) * doublePropertyOf(2.0)).value)
        // observable double to double
        assertEquals(2.0, (doublePropertyOf(1.0) * 2.0).value)
        assertEquals(2.0, (2.0 * doublePropertyOf(1.0)).value)
        // observable double to float
        assertEquals(2.0, (doublePropertyOf(1.0) * 2f).value)
        assertEquals(2.0, (2f * doublePropertyOf(1.0)).value)
        // observable double to long
        assertEquals(2.0, (doublePropertyOf(1.0) * 2L).value)
        assertEquals(2.0, (2L * doublePropertyOf(1.0)).value)
        // observable double to int
        assertEquals(2.0, (doublePropertyOf(1.0) * 2).value)
        assertEquals(2.0, (2 * doublePropertyOf(1.0)).value)
    }

    @Test fun div() {
        // observable double to observable number
        assertEquals(0.5, (doublePropertyOf(1.0) / doublePropertyOf(2.0)).value)
        // observable double to double
        assertEquals(0.5, (doublePropertyOf(1.0) / 2.0).value)
        assertEquals(2.0, (2.0 / doublePropertyOf(1.0)).value)
        // observable double to float
        assertEquals(0.5, (doublePropertyOf(1.0) / 2f).value)
        assertEquals(2.0, (2f / doublePropertyOf(1.0)).value)
        // observable double to long
        assertEquals(0.5, (doublePropertyOf(1.0) / 2L).value)
        assertEquals(2.0, (2L / doublePropertyOf(1.0)).value)
        // observable double to int
        assertEquals(0.5, (doublePropertyOf(1.0) / 2).value)
        assertEquals(2.0, (2 / doublePropertyOf(1.0)).value)
    }
}
