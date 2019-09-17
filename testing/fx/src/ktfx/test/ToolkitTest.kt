package ktfx.test

import com.sun.javafx.application.PlatformImpl
import kotlin.test.BeforeTest

interface ToolkitTest {

    @BeforeTest fun initToolkit() = PlatformImpl.startup { }
}