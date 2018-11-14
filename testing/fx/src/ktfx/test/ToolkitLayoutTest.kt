package ktfx.test

import org.junit.Test

abstract class ToolkitLayoutTest : ToolkitTest {

    @Test abstract fun newInstance()

    @Test abstract fun withManager()
}