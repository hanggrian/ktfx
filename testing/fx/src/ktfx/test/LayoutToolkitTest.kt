package ktfx.test

import kotlin.test.Test

abstract class LayoutToolkitTest<Manager>(private val manager: Manager) : ToolkitTest {

    @Test
    fun test() = manager.layout()

    abstract fun Manager.layout()
}