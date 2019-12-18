package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorNumberTest {

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

    @Test fun eq() {
        assertTrue((0.0 eq intPropertyOf(0)).value)
        assertTrue((0f eq intPropertyOf(0)).value)
        assertTrue((0L eq intPropertyOf(0)).value)
        assertTrue((0 eq intPropertyOf(0)).value)
    }

    @Test fun neq() {
        assertTrue((0.0 neq intPropertyOf(1)).value)
        assertTrue((0f neq intPropertyOf(1)).value)
        assertTrue((0L neq intPropertyOf(1)).value)
        assertTrue((0 neq intPropertyOf(1)).value)
    }

    @Test fun greater() {
        assertFalse((0.0 greater intPropertyOf(1)).value)
        assertFalse((0f greater intPropertyOf(1)).value)
        assertFalse((0L greater intPropertyOf(1)).value)
        assertFalse((0 greater intPropertyOf(1)).value)
    }

    @Test fun greaterEq() {
        assertTrue((0.0 greaterEq intPropertyOf(0)).value)
        assertTrue((0f greaterEq intPropertyOf(0)).value)
        assertTrue((0L greaterEq intPropertyOf(0)).value)
        assertTrue((0 greaterEq intPropertyOf(0)).value)
    }

    @Test fun less() {
        assertTrue((0.0 less intPropertyOf(1)).value)
        assertTrue((0f less intPropertyOf(1)).value)
        assertTrue((0L less intPropertyOf(1)).value)
        assertTrue((0 less intPropertyOf(1)).value)
    }

    @Test fun lessEq() {
        assertTrue((0.0 lessEq intPropertyOf(0)).value)
        assertTrue((0f lessEq intPropertyOf(0)).value)
        assertTrue((0L lessEq intPropertyOf(0)).value)
        assertTrue((0 lessEq intPropertyOf(0)).value)
    }

    @Test fun min() {
        assertEquals(0.0, (0.0 min intPropertyOf(1)).value)
        assertEquals(0f, (0f min intPropertyOf(1)).value)
        assertEquals(0L, (0L min intPropertyOf(1)).value)
        assertEquals(0, (0 min intPropertyOf(1)).value)
    }

    @Test fun max() {
        assertEquals(1.0, (0.0 max intPropertyOf(1)).value)
        assertEquals(1f, (0f max intPropertyOf(1)).value)
        assertEquals(1L, (0L max intPropertyOf(1)).value)
        assertEquals(1, (0 max intPropertyOf(1)).value)
    }
}
