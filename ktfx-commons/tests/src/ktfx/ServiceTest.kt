package ktfx

import ktfx.test.initToolkit
import java.lang.Thread.sleep
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.fail

class ServiceTest {

    @BeforeTest fun start() = initToolkit()

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

    private fun <V> testService(listener: (TaskBuilder<V>).() -> Unit) {
        buildService(listener).start()
        sleep(1000)
    }
}
