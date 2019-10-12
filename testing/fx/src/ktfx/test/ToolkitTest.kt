package ktfx.test

import com.sun.javafx.application.PlatformImpl
import kotlin.test.BeforeTest

/** General test that requires JavaFX toolkit. */
interface ToolkitTest {

    @BeforeTest fun initToolkit() = PlatformImpl.startup { }
}