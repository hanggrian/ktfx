package ktfx

import ktfx.time.m
import ktfx.time.s
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsOperatorObjectTest {

    @Test fun eq() {
        assertFalse((property<Duration>() eq property(1.m)).value)
        assertTrue((property(60.s) eq property(1.m)).value)
    }

    @Test fun neq() {
        assertTrue((property<Duration>() neq property(1.m)).value)
        assertFalse((property(60.s) neq property(1.m)).value)
    }
}
