package ktfx.concurrent

import ktfx.test.ToolkitTest
import org.junit.Test
import java.lang.Thread.sleep
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.fail

class ServiceTest : ToolkitTest {

    @Test fun nullTest() = testService<Any> {
        setOnSucceeded {
            assertNull(value)
        }
    }

    @Test fun simple() = testService<Int> {
        call { 17 }
        setOnSucceeded {
            assertEquals(17, value)
            assertNotEquals(71, value)
        }
    }

    @Test fun expectFailure() = testService<String> {
        call { error("Sad face") }
        setOnFailed {
            assertTrue(it.source.exception is IllegalStateException)
        }
        setOnSucceeded {
            fail("Should not succeed.")
        }
    }

    private companion object {
        fun <V> testService(listener: (_Task<V>).() -> Unit) {
            buildService(listener).start()
            sleep(1000)
        }
    }
}