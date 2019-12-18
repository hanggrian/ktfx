package ktfx.internal

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class KtfxInternalsTest {

    @Test fun noGetter() {
        assertEquals(KtfxInternals.NO_GETTER, assertFails { KtfxInternals.noGetter() }.message)
    }

    @Test fun noReturn() {
        var size = 0
        KtfxInternals.noReturn<String> { size = it.length }.call("Hello world")
        assertEquals(11, size)
    }
}