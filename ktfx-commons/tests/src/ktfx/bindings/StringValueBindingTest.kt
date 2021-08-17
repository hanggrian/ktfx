package ktfx.bindings

import ktfx.stringPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringValueBindingTest {

    @Test
    fun eq() {
        assertFalse((stringPropertyOf("Hello") eq stringPropertyOf("World")).value)
        assertFalse((stringPropertyOf("Hello") eq "World").value)
        assertFalse(("Hello" eq stringPropertyOf("World")).value)
    }

    @Test
    fun neq() {
        assertTrue((stringPropertyOf("Hello") neq stringPropertyOf("World")).value)
        assertTrue((stringPropertyOf("Hello") neq "World").value)
        assertTrue(("Hello" neq stringPropertyOf("World")).value)
    }

    @Test
    fun eqIg() {
        assertTrue((stringPropertyOf("Hello") eqIg stringPropertyOf("hello")).value)
        assertTrue((stringPropertyOf("Hello") eqIg "hello").value)
        assertTrue(("Hello" eqIg stringPropertyOf("hello")).value)
    }

    @Test
    fun neqIg() {
        assertFalse((stringPropertyOf("Hello") neqIg stringPropertyOf("hello")).value)
        assertFalse((stringPropertyOf("Hello") neqIg "hello").value)
        assertFalse(("Hello" neqIg stringPropertyOf("hello")).value)
    }

    @Test
    fun greater() {
        assertFalse((stringPropertyOf("Hello") greater stringPropertyOf("World")).value)
        assertFalse((stringPropertyOf("Hello") greater "World").value)
        assertFalse(("Hello" greater stringPropertyOf("World")).value)
    }

    @Test
    fun less() {
        assertTrue((stringPropertyOf("Hello") less stringPropertyOf("World")).value)
        assertTrue((stringPropertyOf("Hello") less "World").value)
        assertTrue(("Hello" less stringPropertyOf("World")).value)
    }

    @Test
    fun greaterEq() {
        assertTrue((stringPropertyOf("Hello") greaterEq stringPropertyOf("Hello")).value)
        assertTrue((stringPropertyOf("Hello") greaterEq "Hello").value)
        assertTrue(("Hello" greaterEq stringPropertyOf("Hello")).value)
    }

    @Test
    fun lessEq() {
        assertTrue((stringPropertyOf("Hello") lessEq stringPropertyOf("Hello")).value)
        assertTrue((stringPropertyOf("Hello") lessEq "Hello").value)
        assertTrue(("Hello" lessEq stringPropertyOf("Hello")).value)
    }

    @Test
    fun length() = assertEquals(5, (stringPropertyOf("Hello").length().value))
}
