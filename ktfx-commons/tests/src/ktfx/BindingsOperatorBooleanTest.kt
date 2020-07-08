package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsOperatorBooleanTest {

    @Test fun and() {
        assertFalse((booleanProperty(false) and booleanProperty(false)).value)
        assertFalse((booleanProperty(false) and booleanProperty(true)).value)
        assertTrue((booleanProperty(true) and booleanProperty(true)).value)
    }

    @Test fun or() {
        assertFalse((booleanProperty(false) or booleanProperty(false)).value)
        assertTrue((booleanProperty(false) or booleanProperty(true)).value)
        assertTrue((booleanProperty(true) or booleanProperty(true)).value)
    }

    @Test fun eq() {
        assertTrue((booleanProperty(false) eq booleanProperty(false)).value)
        assertFalse((booleanProperty(false) eq booleanProperty(true)).value)
        assertTrue((booleanProperty(true) eq booleanProperty(true)).value)
    }

    @Test fun neq() {
        assertFalse((booleanProperty(false) neq booleanProperty(false)).value)
        assertTrue((booleanProperty(false) neq booleanProperty(true)).value)
        assertFalse((booleanProperty(true) neq booleanProperty(true)).value)
    }
}
