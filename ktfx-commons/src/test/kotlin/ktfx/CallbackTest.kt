package ktfx

import javafx.util.Duration
import ktfx.time.m
import ktfx.time.s
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CallbackTest {
    @Test
    fun callbackOf() {
        assertNull(callbackOf<Duration, Double> { null }.call(Duration.INDEFINITE))
        assertEquals(1000.0, callbackOf<Duration, Double> { it.toMillis() }.call(1.s))
    }

    @Test
    fun invoke() {
        val callback = callbackOf<Int, Duration> { it.m }
        assertEquals(callback.call(1), callback(1))
    }
}
