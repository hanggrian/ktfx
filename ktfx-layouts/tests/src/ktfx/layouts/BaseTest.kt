package ktfx.layouts

import ktfx.application.initToolkit
import org.junit.Before

open class BaseTest {

    @Before fun init() = initToolkit { }
}