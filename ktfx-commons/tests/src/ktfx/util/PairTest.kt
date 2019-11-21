package ktfx.util

import kotlin.test.Test
import kotlin.test.assertEquals

class PairTest {

    @Test fun toKotlinPair() {
        val (s, i) = Pair("Hello", 123).toFxPair()
        assertEquals("Hello", s)
        assertEquals(123, i)
    }

    @Test fun toFxPair() {
        val (s, i) = javafx.util.Pair("Hello", 123).toKotlinPair()
        assertEquals("Hello", s)
        assertEquals(123, i)
    }
}