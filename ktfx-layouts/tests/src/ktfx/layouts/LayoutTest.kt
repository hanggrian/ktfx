package ktfx.layouts

import ktfx.test.ToolkitInitializer
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/** There are 3 ways to create/add a child. This test ensures that each way produces the same child result. */
abstract class LayoutTest<M : BaseManager<in C>, C> : ToolkitInitializer {
    private lateinit var manager: M

    @BeforeTest fun initManager() {
        manager = createManager()
    }

    abstract fun createManager(): M

    abstract fun create(): C

    abstract fun M.add(): C

    abstract fun M.addWithBuilder(): C

    /** Override to test default values. */
    open fun C.testDefaultValues() {
    }

    @Test fun createWithBuilder() {
        val child = create()
        child.testDefaultValues()
        assertEquals(0, manager.childCount)
    }

    @Test fun add() {
        val child = manager.addWithBuilder()
        child.testDefaultValues()
        assertEquals(1, manager.childCount)
    }

    @Test fun addWithBuilder() {
        val child = manager.add()
        child.testDefaultValues()
        assertEquals(1, manager.childCount)
    }
}