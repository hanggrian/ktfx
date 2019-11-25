package ktfx.test

import com.sun.javafx.application.PlatformImpl
import kotlin.test.BeforeTest

/** Some tests requires JavaFX toolkit, this test will initialize it upon running. */
interface ToolkitTest {

    @BeforeTest fun initToolkit() = PlatformImpl.startup { }
}
