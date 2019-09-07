package ktfx

import javafx.application.ConditionalFeature
import ktfx.test.ToolkitTest
import ktfx.test.assertContains
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformTest : ToolkitTest {

    @Test
    fun isInFx2() {
        assertFalse(isFxThread())
        runLater { assertTrue(isFxThread()) }
        runAndWait { assertTrue(isFxThread()) }
    }

    @Test
    fun later() {
        val list = mutableListOf<Int>()
        runLater {
            list += 1
            assertContains(list, 2, 1).inOrder()
        }
        list += 2
    }

    /** Exactly like [runLater] because junit does not run in fx thread.*/
    @Test
    fun now() {
        val list = mutableListOf<Int>()
        runLater {
            list += 1
            assertContains(list, 2, 1).inOrder()
        }
        list += 2
    }

    @Test
    fun wait2() {
        val list = mutableListOf<Int>()
        runAndWait {
            list += 1
        }
        list += 2
        assertContains(list, 1, 2).inOrder()
    }

    @Test
    fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}