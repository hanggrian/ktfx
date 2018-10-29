package ktfx

import ktfx.internal.KtfxManager
import ktfx.test.assertContains
import ktfx.test.assertEmpty
import ktfx.test.assertNotEmpty
import org.junit.Test

class KtfxManagerTest {

    @Test fun empty() {
        val manager = KtfxManager.empty<Int>()
        assertEmpty(manager.collection)
        assertContains(manager.apply {
            1()
            2()
            3()
        }.collection, 1, 2, 3)
        assertNotEmpty(manager.collection)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun invokableOnly() {
        NodeManager.invokableOnly().collection
    }
}