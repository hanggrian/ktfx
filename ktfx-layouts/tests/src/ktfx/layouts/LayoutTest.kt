package ktfx.layouts

import org.junit.Test

abstract class LayoutTest : BaseTest() {

    @Test abstract fun newInstance()

    @Test abstract fun newInstanceInitialized()

    @Test abstract fun withManager()

    @Test abstract fun withManagerInitialized()
}