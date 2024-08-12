package ktfx

import javafx.util.Callback
import javafx.util.Duration
import ktfx.time.m
import kotlin.test.Test
import kotlin.test.assertEquals

class CallbackTest {
    @Test
    fun invoke() {
        val callback = Callback<Int, Duration> { it.m }
        assertEquals(callback.call(1), callback(1))
    }
}
