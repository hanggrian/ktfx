package ktfx.application

import com.google.common.truth.Truth
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

    @Test fun later() {
        val list = mutableListOf<Int>()
        later {
            list += 1
            Truth.assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2
    }

    @Test fun wait2() {
        val list = mutableListOf<Int>()
        wait {
            list += 1
        }
        list += 2
        Truth.assertThat(list).containsExactly(1, 2).inOrder()
    }

    @Test fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}