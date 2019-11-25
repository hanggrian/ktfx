package ktfx.test

import kotlin.test.Test

/** In addition to `ToolkitTest`, this test is designed for `ktfx-layouts` and its submodules. */
abstract class LayoutToolkitTest<Manager>(private val manager: Manager) : ToolkitTest {

    @Test fun test() = manager.layout()

    abstract fun Manager.layout()
}
