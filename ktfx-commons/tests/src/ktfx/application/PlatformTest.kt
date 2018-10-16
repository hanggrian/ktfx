package ktfx.application

import javafx.application.ConditionalFeature
import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformTest : ToolkitTest {

    @Test fun fxThread() {
        assertFalse(ktfx.application.isFxThread())
        later {
            assertTrue(ktfx.application.isFxThread())
        }
        "Hello".runLater {
            assertTrue(ktfx.application.isFxThread())
            assertEquals("Hello", this)
        }
        "World".letLater {
            assertTrue(ktfx.application.isFxThread())
            assertEquals("World", it)
        }
    }

    @Test fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}