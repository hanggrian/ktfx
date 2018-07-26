package javafxx.test

import org.junit.Test

abstract class PlatformLayoutTest : PlatformTest() {

    @Test abstract fun newInstance()

    @Test abstract fun newInstanceInitialized()

    @Test abstract fun withManager()

    @Test abstract fun withManagerInitialized()
}