package ktfx.internal

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class KtfxInternalsTest {

    @Test fun noGetter() = assertEquals(KtfxInternals.NO_GETTER, assertFails { KtfxInternals.noGetter() }.message)
}