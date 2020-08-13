package ktfx.bindings

import ktfx.intPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ComparisonsBindingTest {

    @Test fun maxOf() {
        assertEquals(2, maxOf(intPropertyOf(1), intPropertyOf(2)).value)
        assertEquals(2.0, maxOf(intPropertyOf(1), 2.0).value)
        assertEquals(2.0, maxOf(2.0, intPropertyOf(1)).value)
        assertEquals(2f, maxOf(intPropertyOf(1), 2f).value)
        assertEquals(2f, maxOf(2f, intPropertyOf(1)).value)
        assertEquals(2L, maxOf(intPropertyOf(1), 2L).value)
        assertEquals(2L, maxOf(2L, intPropertyOf(1)).value)
        assertEquals(2, maxOf(intPropertyOf(1), 2).value)
        assertEquals(2, maxOf(2, intPropertyOf(1)).value)
    }

    @Test fun minOf() {
        assertEquals(1, minOf(intPropertyOf(1), intPropertyOf(2)).value)
        assertEquals(1.0, minOf(intPropertyOf(1), 2.0).value)
        assertEquals(1.0, minOf(2.0, intPropertyOf(1)).value)
        assertEquals(1f, minOf(intPropertyOf(1), 2f).value)
        assertEquals(1f, minOf(2f, intPropertyOf(1)).value)
        assertEquals(1L, minOf(intPropertyOf(1), 2L).value)
        assertEquals(1L, minOf(2L, intPropertyOf(1)).value)
        assertEquals(1, minOf(intPropertyOf(1), 2).value)
        assertEquals(1, minOf(2, intPropertyOf(1)).value)
    }
}