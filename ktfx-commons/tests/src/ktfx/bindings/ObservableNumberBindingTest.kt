package ktfx.bindings

import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/** Most of these tests avoid double, since they have their own tests. */
class ObservableNumberBindingTest {

    @Test fun plus() {
        assertEquals(3f, (floatPropertyOf(1f) + floatPropertyOf(2f)).value)
        assertEquals(3L, (longPropertyOf(1L) + longPropertyOf(2L)).value)
        assertEquals(3, (intPropertyOf(1) + intPropertyOf(2)).value)
    }

    @Test fun minus() {
        assertEquals(-1f, (floatPropertyOf(1f) - floatPropertyOf(2f)).value)
        assertEquals(-1L, (longPropertyOf(1L) - longPropertyOf(2L)).value)
        assertEquals(-1, (intPropertyOf(1) - intPropertyOf(2)).value)
    }

    @Test fun times() {
        assertEquals(2f, (floatPropertyOf(1f) * floatPropertyOf(2f)).value)
        assertEquals(2L, (longPropertyOf(1L) * longPropertyOf(2L)).value)
        assertEquals(2, (intPropertyOf(1) * intPropertyOf(2)).value)
    }

    @Test fun div() {
        assertEquals(0.5f, (floatPropertyOf(1f) / floatPropertyOf(2f)).value)
        assertEquals(0L, (longPropertyOf(1L) / longPropertyOf(2L)).value)
        assertEquals(0, (intPropertyOf(1) / intPropertyOf(2)).value)
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

    @Test fun less() {
        assertTrue((0.0 less intPropertyOf(1)).value)
        assertTrue((0f less intPropertyOf(1)).value)
        assertTrue((0L less intPropertyOf(1)).value)
        assertTrue((0 less intPropertyOf(1)).value)
    }

    @Test fun greaterEq() {
        assertTrue((0.0 greaterEq intPropertyOf(0)).value)
        assertTrue((0f greaterEq intPropertyOf(0)).value)
        assertTrue((0L greaterEq intPropertyOf(0)).value)
        assertTrue((0 greaterEq intPropertyOf(0)).value)
    }

    @Test fun lessEq() {
        assertTrue((0.0 lessEq intPropertyOf(0)).value)
        assertTrue((0f lessEq intPropertyOf(0)).value)
        assertTrue((0L lessEq intPropertyOf(0)).value)
        assertTrue((0 lessEq intPropertyOf(0)).value)
    }
}
