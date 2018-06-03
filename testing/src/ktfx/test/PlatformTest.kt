package ktfx.test

import com.sun.javafx.application.PlatformImpl
import org.junit.Before

open class PlatformTest {

    @Before fun init() = PlatformImpl.startup { }
}