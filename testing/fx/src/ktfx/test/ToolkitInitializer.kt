package ktfx.test

import com.sun.javafx.application.PlatformImpl
import kotlin.test.BeforeTest

/** Some tests requires JavaFX toolkit, implementing this interface will initialize it upon running. */
interface ToolkitInitializer {

    @BeforeTest fun initToolkit() = PlatformImpl.startup { }
}
