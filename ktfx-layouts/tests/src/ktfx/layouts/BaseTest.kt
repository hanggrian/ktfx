package ktfx.layouts

import ktfx.application.Platform
import org.junit.Before

open class BaseTest {

    @Before fun init() = Platform.startup { }
}