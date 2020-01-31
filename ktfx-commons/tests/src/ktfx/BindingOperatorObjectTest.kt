package ktfx

import ktfx.time.m
import ktfx.time.s
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorObjectTest {

    @Test fun eq() {
        assertFalse((propertyOf<Duration>() eq propertyOf(1.m)).value)
        assertTrue((propertyOf(60.s) eq propertyOf(1.m)).value)
    }

    @Test fun neq() {
        assertTrue((propertyOf<Duration>() neq propertyOf(1.m)).value)
        assertFalse((propertyOf(60.s) neq propertyOf(1.m)).value)
    }
}
