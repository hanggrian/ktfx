package ktfx.bindings

import ktfx.propertyOf
import ktfx.time.m
import ktfx.time.s
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObjectValueBindingTest {
    @Test
    fun eq() {
        assertFalse((propertyOf(Duration.ZERO) eq propertyOf(1.m)).value)
        assertFalse((Duration.ZERO eq propertyOf(1.m)).value)
        assertFalse((propertyOf(Duration.ZERO) eq 1.m).value)

        assertTrue((propertyOf(60.s) eq propertyOf(1.m)).value)
        assertTrue((60.s eq propertyOf(1.m)).value)
        assertTrue((propertyOf(60.s) eq 1.m).value)
    }

    @Test
    fun neq() {
        assertTrue((propertyOf(Duration.ZERO) neq propertyOf(1.m)).value)
        assertTrue((Duration.ZERO neq propertyOf(1.m)).value)
        assertTrue((propertyOf(Duration.ZERO) neq 1.m).value)

        assertFalse((propertyOf(60.s) neq propertyOf(1.m)).value)
        assertFalse((60.s neq propertyOf(1.m)).value)
        assertFalse((propertyOf(60.s) neq 1.m).value)
    }

    @Test
    fun nullBinding() {
        val duration = propertyOf(Duration.ZERO)
        val binding = duration.nullBinding
        assertFalse(binding.value)
        duration.set(null)
        assertTrue(binding.value)
    }

    @Test
    fun notNullBinding() {
        val duration = propertyOf(Duration.ZERO)
        val binding = duration.notNullBinding
        assertTrue(binding.value)
        duration.set(null)
        assertFalse(binding.value)
    }
}
