package ktfx

import javafx.beans.property.SimpleIntegerProperty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorNumberTest {

    @Test fun plus() {
        assertEquals(3.0, (1.0 + SimpleIntegerProperty(2)).value)
        assertEquals(3f, (1f + SimpleIntegerProperty(2)).value)
        assertEquals(3, (1L + SimpleIntegerProperty(2)).value)
        assertEquals(3, (1 + SimpleIntegerProperty(2)).value)
    }

    @Test fun minus() {
        assertEquals(3.0, (5.0 - SimpleIntegerProperty(2)).value)
        assertEquals(3f, (5f - SimpleIntegerProperty(2)).value)
        assertEquals(3, (5L - SimpleIntegerProperty(2)).value)
        assertEquals(3, (5 - SimpleIntegerProperty(2)).value)
    }

    @Test fun times() {
        assertEquals(6.0, (3.0 * SimpleIntegerProperty(2)).value)
        assertEquals(6f, (3f * SimpleIntegerProperty(2)).value)
        assertEquals(6, (3L * SimpleIntegerProperty(2)).value)
        assertEquals(6, (3 * SimpleIntegerProperty(2)).value)
    }

    @Test fun div() {
        assertEquals(2.0, (4.0 / SimpleIntegerProperty(2)).value)
        assertEquals(2f, (4f / SimpleIntegerProperty(2)).value)
        assertEquals(2, (4L / SimpleIntegerProperty(2)).value)
        assertEquals(2, (4 / SimpleIntegerProperty(2)).value)
    }

    @Test fun eq() {
        assertTrue((0.0 eq SimpleIntegerProperty(0)).value)
        assertTrue((0f eq SimpleIntegerProperty(0)).value)
        assertTrue((0L eq SimpleIntegerProperty(0)).value)
        assertTrue((0 eq SimpleIntegerProperty(0)).value)
    }

    @Test fun neq() {
        assertTrue((0.0 neq SimpleIntegerProperty(1)).value)
        assertTrue((0f neq SimpleIntegerProperty(1)).value)
        assertTrue((0L neq SimpleIntegerProperty(1)).value)
        assertTrue((0 neq SimpleIntegerProperty(1)).value)
    }

    @Test fun greater() {
        assertFalse((0.0 greater SimpleIntegerProperty(1)).value)
        assertFalse((0f greater SimpleIntegerProperty(1)).value)
        assertFalse((0L greater SimpleIntegerProperty(1)).value)
        assertFalse((0 greater SimpleIntegerProperty(1)).value)
    }

    @Test fun greaterEq() {
        assertTrue((0.0 greaterEq SimpleIntegerProperty(0)).value)
        assertTrue((0f greaterEq SimpleIntegerProperty(0)).value)
        assertTrue((0L greaterEq SimpleIntegerProperty(0)).value)
        assertTrue((0 greaterEq SimpleIntegerProperty(0)).value)
    }

    @Test fun less() {
        assertTrue((0.0 less SimpleIntegerProperty(1)).value)
        assertTrue((0f less SimpleIntegerProperty(1)).value)
        assertTrue((0L less SimpleIntegerProperty(1)).value)
        assertTrue((0 less SimpleIntegerProperty(1)).value)
    }

    @Test fun lessEq() {
        assertTrue((0.0 lessEq SimpleIntegerProperty(0)).value)
        assertTrue((0f lessEq SimpleIntegerProperty(0)).value)
        assertTrue((0L lessEq SimpleIntegerProperty(0)).value)
        assertTrue((0 lessEq SimpleIntegerProperty(0)).value)
    }

    @Test fun min() {
        assertEquals(0.0, (0.0 min SimpleIntegerProperty(1)).value)
        assertEquals(0f, (0f min SimpleIntegerProperty(1)).value)
        assertEquals(0L, (0L min SimpleIntegerProperty(1)).value)
        assertEquals(0, (0 min SimpleIntegerProperty(1)).value)
    }

    @Test fun max() {
        assertEquals(1.0, (0.0 max SimpleIntegerProperty(1)).value)
        assertEquals(1f, (0f max SimpleIntegerProperty(1)).value)
        assertEquals(1L, (0L max SimpleIntegerProperty(1)).value)
        assertEquals(1, (0 max SimpleIntegerProperty(1)).value)
    }
}
