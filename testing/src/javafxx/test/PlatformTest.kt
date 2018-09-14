package javafxx.test

import com.sun.javafx.application.PlatformImpl
import org.junit.Before

interface PlatformTest {

    @Before fun initToolkit() = PlatformImpl.startup { }
}