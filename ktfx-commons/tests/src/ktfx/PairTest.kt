package ktfx

import javafx.util.Pair
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PairTest {

    @Test
    fun toKotlinPair() {
        val (s, i) = Pair("Hello", 123).toKotlinPair()
        assertEquals("Hello", s)
        assertEquals(123, i)

        val (n1, n2) = Pair(null, null).toKotlinPair()
        assertNull(n1)
        assertNull(n2)
    }

    @Test
    fun toFxPair() {
        val (s, i) = kotlin.Pair("Hello", 123).toFxPair()
        assertEquals("Hello", s)
        assertEquals(123, i)

        val (n1, n2) = kotlin.Pair(null, null).toFxPair()
        assertNull(n1)
        assertNull(n2)
    }
}
