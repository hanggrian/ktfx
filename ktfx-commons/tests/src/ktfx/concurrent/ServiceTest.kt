package ktfx.concurrent

import com.sun.javafx.application.PlatformImpl
import ktfx.internal._Task
import org.junit.Before
import org.junit.Test
import java.lang.Thread.sleep
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.fail

class ServiceTest {

    @Before fun startup() = PlatformImpl.startup { }

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