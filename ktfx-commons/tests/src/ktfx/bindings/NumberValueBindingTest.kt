package ktfx.bindings

import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/** Most of these tests avoid double, since they have their own tests. */
class NumberValueBindingTest {

    @Test fun plus() = assertEquals(3, (intPropertyOf(1) + intPropertyOf(2)).value)

    @Test fun minus() = assertEquals(-1, (intPropertyOf(1) - intPropertyOf(2)).value)

    @Test fun times() = assertEquals(2, (intPropertyOf(1) * intPropertyOf(2)).value)

    @Test fun div() = assertEquals(0, (intPropertyOf(1) / intPropertyOf(2)).value)

    @Test fun eq() {
        // observable number to observable number
        assertTrue((intPropertyOf(0) eq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0).eq(intPropertyOf(0), 0.0)).value)
        // observable number to double
        assertTrue((0.0 eq intPropertyOf(0)).value)
        assertTrue((0.0.eq(intPropertyOf(0), 0.0)).value)
        assertTrue((intPropertyOf(0) eq 0.0).value)
        assertTrue((intPropertyOf(0).eq(0.0, 0.0)).value)
        // observable number to float
        assertTrue((0f eq intPropertyOf(0)).value)
        assertTrue((0f.eq(intPropertyOf(0), 0.0)).value)
        assertTrue((intPropertyOf(0) eq 0f).value)
        assertTrue((intPropertyOf(0).eq(0f, 0.0)).value)
        // observable number to long
        assertTrue((0L eq intPropertyOf(0)).value)
        assertTrue((0L.eq(intPropertyOf(0), 0.0)).value)
        assertTrue((intPropertyOf(0) eq 0L).value)
        assertTrue((intPropertyOf(0).eq(0L, 0.0)).value)
        // observable number to int
        assertTrue((0 eq intPropertyOf(0)).value)
        assertTrue((0.eq(intPropertyOf(0), 0.0)).value)
        assertTrue((intPropertyOf(0) eq 0).value)
        assertTrue((intPropertyOf(0).eq(0, 0.0)).value)
    }

    @Test fun neq() {
        // observable number to observable number
        assertFalse((intPropertyOf(0) neq intPropertyOf(0)).value)
        assertFalse((intPropertyOf(0).neq(intPropertyOf(0), 0.0)).value)
        // observable number to double
        assertFalse((0.0 neq intPropertyOf(0)).value)
        assertFalse((0.0.neq(intPropertyOf(0), 0.0)).value)
        assertFalse((intPropertyOf(0) neq 0.0).value)
        assertFalse((intPropertyOf(0).neq(0.0, 0.0)).value)
        // observable number to float
        assertFalse((0f neq intPropertyOf(0)).value)
        assertFalse((0f.neq(intPropertyOf(0), 0.0)).value)
        assertFalse((intPropertyOf(0) neq 0f).value)
        assertFalse((intPropertyOf(0).neq(0f, 0.0)).value)
        // observable number to long
        assertFalse((0L neq intPropertyOf(0)).value)
        assertFalse((0L.neq(intPropertyOf(0), 0.0)).value)
        assertFalse((intPropertyOf(0) neq 0L).value)
        assertFalse((intPropertyOf(0).neq(0L, 0.0)).value)
        // observable number to int
        assertFalse((0 neq intPropertyOf(0)).value)
        assertFalse((0.neq(intPropertyOf(0), 0.0)).value)
        assertFalse((intPropertyOf(0) neq 0).value)
        assertFalse((intPropertyOf(0).neq(0, 0.0)).value)
    }

    @Test fun greater() {
        // observable number to observable number
        assertFalse((intPropertyOf(0) greater intPropertyOf(1)).value)
        // observable number to double
        assertFalse((0.0 greater intPropertyOf(1)).value)
        assertTrue((intPropertyOf(1) greater 0.0).value)
        // observable number to float
        assertFalse((0f greater intPropertyOf(1)).value)
        assertTrue((intPropertyOf(1) greater 0f).value)
        // observable number to long
        assertFalse((0L greater intPropertyOf(1)).value)
        assertTrue((intPropertyOf(1) greater 0L).value)
        // observable number to int
        assertFalse((0 greater intPropertyOf(1)).value)
        assertTrue((intPropertyOf(1) greater 0).value)
    }

    @Test fun less() {
        // observable number to observable number
        assertTrue((intPropertyOf(0) less intPropertyOf(1)).value)
        // observable number to double
        assertTrue((0.0 less intPropertyOf(1)).value)
        assertFalse((intPropertyOf(1) less 0.0).value)
        // observable number to float
        assertTrue((0f less intPropertyOf(1)).value)
        assertFalse((intPropertyOf(1) less 0f).value)
        // observable number to long
        assertTrue((0L less intPropertyOf(1)).value)
        assertFalse((intPropertyOf(1) less 0L).value)
        // observable number to int
        assertTrue((0 less intPropertyOf(1)).value)
        assertFalse((intPropertyOf(1) less 0).value)
    }

    @Test fun greaterEq() {
        // observable number to observable number
        assertTrue((intPropertyOf(0) greaterEq intPropertyOf(0)).value)
        // observable number to double
        assertTrue((0.0 greaterEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) greaterEq 0.0).value)
        // observable number to float
        assertTrue((0f greaterEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) greaterEq 0f).value)
        // observable number to long
        assertTrue((0L greaterEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) greaterEq 0L).value)
        // observable number to int
        assertTrue((0 greaterEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) greaterEq 0).value)
    }

    @Test fun lessEq() {
        // observable number to observable number
        assertTrue((intPropertyOf(0) lessEq intPropertyOf(0)).value)
        // observable number to double
        assertTrue((0.0 lessEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) lessEq 0.0).value)
        // observable number to float
        assertTrue((0f lessEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) lessEq 0f).value)
        // observable number to long
        assertTrue((0L lessEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) lessEq 0L).value)
        // observable number to int
        assertTrue((0 lessEq intPropertyOf(0)).value)
        assertTrue((intPropertyOf(0) lessEq 0).value)
    }
}
