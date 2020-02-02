package ktfx

import javafx.beans.property.SimpleBooleanProperty
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorBooleanTest {

    @Test fun and() {
        assertFalse((SimpleBooleanProperty(false) and SimpleBooleanProperty(false)).value)
        assertFalse((SimpleBooleanProperty(false) and SimpleBooleanProperty(true)).value)
        assertTrue((SimpleBooleanProperty(true) and SimpleBooleanProperty(true)).value)
    }

    @Test fun or() {
        assertFalse((SimpleBooleanProperty(false) or SimpleBooleanProperty(false)).value)
        assertTrue((SimpleBooleanProperty(false) or SimpleBooleanProperty(true)).value)
        assertTrue((SimpleBooleanProperty(true) or SimpleBooleanProperty(true)).value)
    }

    @Test fun eq() {
        assertTrue((SimpleBooleanProperty(false) eq SimpleBooleanProperty(false)).value)
        assertFalse((SimpleBooleanProperty(false) eq SimpleBooleanProperty(true)).value)
        assertTrue((SimpleBooleanProperty(true) eq SimpleBooleanProperty(true)).value)
    }

    @Test fun neq() {
        assertFalse((SimpleBooleanProperty(false) neq SimpleBooleanProperty(false)).value)
        assertTrue((SimpleBooleanProperty(false) neq SimpleBooleanProperty(true)).value)
        assertFalse((SimpleBooleanProperty(true) neq SimpleBooleanProperty(true)).value)
    }
}
