package ktfx

import ktfx.internal.KtfxManager
import ktfx.test.assertContains
import org.junit.Test

class KtfxManagerTest {

    private val manager = KtfxManager.empty<Int>()

    @Test fun test() {
        assertContains(manager.apply {
            1()
            2()
            3()
        }.collection, 1, 2, 3)
    }
}