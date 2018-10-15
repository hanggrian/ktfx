package ktfx.test

import org.junit.Test

abstract class PlatformLayoutTest : PlatformTest {

    @Test abstract fun newInstance()

    @Test abstract fun withManager()
}