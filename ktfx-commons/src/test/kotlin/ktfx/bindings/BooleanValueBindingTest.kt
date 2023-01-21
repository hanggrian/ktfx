package ktfx.bindings

import ktfx.booleanPropertyOf
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BooleanValueBindingTest {
    @Test
    fun and() {
        assertFalse((booleanPropertyOf(false) and booleanPropertyOf(false)).value)
        assertFalse((booleanPropertyOf(false) and booleanPropertyOf(true)).value)
        assertTrue((booleanPropertyOf(true) and booleanPropertyOf(true)).value)
    }

    @Test
    fun or() {
        assertFalse((booleanPropertyOf(false) or booleanPropertyOf(false)).value)
        assertTrue((booleanPropertyOf(false) or booleanPropertyOf(true)).value)
        assertTrue((booleanPropertyOf(true) or booleanPropertyOf(true)).value)
    }

    @Test
    fun eq() {
        assertTrue((booleanPropertyOf(false) eq booleanPropertyOf(false)).value)
        assertFalse((booleanPropertyOf(false) eq booleanPropertyOf(true)).value)
        assertTrue((booleanPropertyOf(true) eq booleanPropertyOf(true)).value)
    }

    @Test
    fun neq() {
        assertFalse((booleanPropertyOf(false) neq booleanPropertyOf(false)).value)
        assertTrue((booleanPropertyOf(false) neq booleanPropertyOf(true)).value)
        assertFalse((booleanPropertyOf(true) neq booleanPropertyOf(true)).value)
    }
}
