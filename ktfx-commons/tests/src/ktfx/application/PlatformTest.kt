package ktfx.application

import javafx.application.ConditionalFeature
import ktfx.test.ToolkitTest
import ktfx.test.assertContains
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformTest : ToolkitTest {

    @Test fun isInFx2() {
        assertFalse(isInFx())
        later { assertTrue(isInFx()) }
        now { assertTrue(isInFx()) }
        wait { assertTrue(isInFx()) }
    }

    @Test fun later() {
        val list = mutableListOf<Int>()
        later {
            list += 1
            assertContains(list, 2, 1).inOrder()
        }
        list += 2
    }

    /** Exactly like [later] because junit does not run in fx thread.*/
    @Test fun now() {
        val list = mutableListOf<Int>()
        later {
            list += 1
            assertContains(list, 2, 1).inOrder()
        }
        list += 2
    }

    @Test fun wait2() {
        val list = mutableListOf<Int>()
        wait {
            list += 1
        }
        list += 2
        assertContains(list, 1, 2).inOrder()
    }

    @Test fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}