package ktfx

import javafx.beans.property.SimpleObjectProperty
import ktfx.time.m
import ktfx.time.s
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsOperatorObjectTest {

    @Test fun eq() {
        assertFalse((SimpleObjectProperty<Duration>() eq SimpleObjectProperty(1.m)).value)
        assertTrue((SimpleObjectProperty(60.s) eq SimpleObjectProperty(1.m)).value)
    }

    @Test fun neq() {
        assertTrue((SimpleObjectProperty<Duration>() neq SimpleObjectProperty(1.m)).value)
        assertFalse((SimpleObjectProperty(60.s) neq SimpleObjectProperty(1.m)).value)
    }
}
