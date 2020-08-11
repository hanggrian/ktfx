package ktfx

import ktfx.time.m
import ktfx.time.s
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ObservableObjectValue {
    private val anyProperty = property<javafx.util.Duration>()
    private var any by anyProperty

    @Test fun delegate() {
        assertNull(any)
        any = 2.m
        assertEquals(2.m, anyProperty.value)
    }

    @Test fun eq() {
        assertFalse((property<Duration>() eq property(1.m)).value)
        assertTrue((property(60.s) eq property(1.m)).value)
    }

    @Test fun neq() {
        assertTrue((property<Duration>() neq property(1.m)).value)
        assertFalse((property(60.s) neq property(1.m)).value)
    }
}
