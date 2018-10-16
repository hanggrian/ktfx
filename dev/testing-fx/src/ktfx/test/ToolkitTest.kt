package ktfx.test

import com.sun.javafx.application.PlatformImpl
import org.junit.Before

interface ToolkitTest {

    @Before fun initToolkit() = PlatformImpl.startup { }
}