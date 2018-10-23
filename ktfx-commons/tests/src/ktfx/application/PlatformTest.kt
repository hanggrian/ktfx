package ktfx.application

import javafx.application.ConditionalFeature
import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformTest : ToolkitTest {

    @Test fun fxThread() {
        assertFalse(ktfx.application.isFxThread())
        later {
            assertTrue(ktfx.application.isFxThread())
        }
        wait {
            assertTrue(ktfx.application.isFxThread())
        }
    }

    @Test fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}