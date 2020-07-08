package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Test fun eq() {
        assertTrue((0.0 eq intProperty(0)).value)
        assertTrue((0f eq intProperty(0)).value)
        assertTrue((0L eq intProperty(0)).value)
        assertTrue((0 eq intProperty(0)).value)
    }

    @Test fun neq() {
        assertTrue((0.0 neq intProperty(1)).value)
        assertTrue((0f neq intProperty(1)).value)
        assertTrue((0L neq intProperty(1)).value)
        assertTrue((0 neq intProperty(1)).value)
    }

    @Test fun greater() {
        assertFalse((0.0 greater intProperty(1)).value)
        assertFalse((0f greater intProperty(1)).value)
        assertFalse((0L greater intProperty(1)).value)
        assertFalse((0 greater intProperty(1)).value)
    }

    @Test fun greaterEq() {
        assertTrue((0.0 greaterEq intProperty(0)).value)
        assertTrue((0f greaterEq intProperty(0)).value)
        assertTrue((0L greaterEq intProperty(0)).value)
        assertTrue((0 greaterEq intProperty(0)).value)
    }

    @Test fun less() {
        assertTrue((0.0 less intProperty(1)).value)
        assertTrue((0f less intProperty(1)).value)
        assertTrue((0L less intProperty(1)).value)
        assertTrue((0 less intProperty(1)).value)
    }

    @Test fun lessEq() {
        assertTrue((0.0 lessEq intProperty(0)).value)
        assertTrue((0f lessEq intProperty(0)).value)
        assertTrue((0L lessEq intProperty(0)).value)
        assertTrue((0 lessEq intProperty(0)).value)
    }

    @Test fun min() {
        assertEquals(0.0, (0.0 min intProperty(1)).value)
        assertEquals(0f, (0f min intProperty(1)).value)
        assertEquals(0L, (0L min intProperty(1)).value)
        assertEquals(0, (0 min intProperty(1)).value)
    }

    @Test fun max() {
        assertEquals(1.0, (0.0 max intProperty(1)).value)
        assertEquals(1f, (0f max intProperty(1)).value)
        assertEquals(1L, (0L max intProperty(1)).value)
        assertEquals(1, (0 max intProperty(1)).value)
    }
}
