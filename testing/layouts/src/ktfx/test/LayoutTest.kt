package ktfx.test

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/** There are 3 ways to create/add a child. This test ensures that each way produces the same child result. */
abstract class LayoutTest<M : Any, C> {
    lateinit var manager: M

    @BeforeTest open fun onCreate() {
        initToolkit()
        manager = manager()
    }

    abstract fun manager(): M
    abstract fun childCount(): Int
    abstract fun child1(): C
    abstract fun M.child2(): C
    abstract fun M.child3(): C

    /** Override to test default values. */
    open fun C.testDefaultValues() {
    }

    @Test fun createChildWithBuilder() {
        val child = child1()
        child.testDefaultValues()
        assertEquals(0, childCount())
    }

    @Test fun addChild() {
        val child = manager.child3()
        child.testDefaultValues()
        assertEquals(1, childCount())
    }

    @Test fun addChildWithBuilder() {
        val child = manager.child2()
        child.testDefaultValues()
        assertEquals(1, childCount())
    }
}