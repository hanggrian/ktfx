package ktfx.util

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CallbackTest {

    @Test fun callbackOf() {
        assertNull(callbackOf<Duration, Double> { null }.call(Duration.INDEFINITE))
        assertEquals(1000.0, callbackOf<Duration, Double> { it.toMillis() }.call(1.seconds))
    }

    @Test fun invoke() {
        val callback = callbackOf<Int, Duration> { it.minutes }
        assertEquals(callback.call(1), callback(1))
    }
}