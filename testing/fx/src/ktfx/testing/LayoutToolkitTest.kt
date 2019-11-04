package ktfx.testing

import kotlin.test.Test

/** Layout manager test for `ktfx-layouts` and its submodules. */
abstract class LayoutToolkitTest<Manager>(private val manager: Manager) : ToolkitTest {

    @Test
    fun test() = manager.layout()

    abstract fun Manager.layout()
}