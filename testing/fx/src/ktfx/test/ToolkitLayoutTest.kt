package ktfx.test

import org.junit.Test

abstract class ToolkitLayoutTest<Manager>(private val manager: Manager) : ToolkitTest {

    @Test
    abstract fun test()

    protected fun manage(block: Manager.() -> Unit) {
        manager.block()
    }
}

abstract class ToolkitLayoutTest2<Manager> : ToolkitTest {

    abstract val manager: Manager

    @Test
    abstract fun test()

    protected fun manage(block: Manager.() -> Unit) {
        manager.block()
    }
}