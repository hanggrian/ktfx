package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsInfixNumberTest {

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
