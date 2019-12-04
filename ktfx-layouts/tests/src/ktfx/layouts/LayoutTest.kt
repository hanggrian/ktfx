package ktfx.layouts

import kotlin.test.Test
import kotlin.test.assertEquals

/** There are 3 ways to create/add a child. This test ensures that each way produces the same child result. */
abstract class LayoutTest<M : BaseManager<in C>, C>(val manager: M) {

    abstract fun create(): C

    abstract fun M.add(): C

    abstract fun M.addWithBuilder(): C

    abstract fun C.testDefaultValue()

    @Test fun createWithBuilder() {
        val child = create()
        child.testDefaultValue()
    }

    @Test fun add() {
        val child = manager.addWithBuilder()
        child.testDefaultValue()
        assertEquals(1, manager.childCount)
    }

    @Test fun addWithBuilder() {
        val child = manager.add()
        child.testDefaultValue()
        assertEquals(1, manager.childCount)
    }
}