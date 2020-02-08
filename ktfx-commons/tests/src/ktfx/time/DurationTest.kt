package ktfx.time

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

class DurationTest {

    @Test fun toDuration() {
        assertEquals(5000.ms, "5000ms".toDuration())
        assertEquals(500.s, "500s".toDuration())
        assertEquals(50.m, "50m".toDuration())
        assertEquals(5.h, "5h".toDuration())
    }

    @Test fun ms() {
        assertEquals(Duration.millis(5000.0), 5000.ms)
        assertEquals(Duration.millis(5000.0), 5000L.ms)
        assertEquals(Duration.millis(5000.0), 5000.0.ms)
    }

    @Test fun s() {
        assertEquals(Duration.seconds(500.0), 500.s)
        assertEquals(Duration.seconds(500.0), 500L.s)
        assertEquals(Duration.seconds(500.0), 500.0.s)
    }

    @Test fun m() {
        assertEquals(Duration.minutes(50.0), 50.m)
        assertEquals(Duration.minutes(50.0), 50L.m)
        assertEquals(Duration.minutes(50.0), 50.0.m)
    }

    @Test fun h() {
        assertEquals(Duration.hours(5.0), 5.h)
        assertEquals(Duration.hours(5.0), 5L.h)
        assertEquals(Duration.hours(5.0), 5.0.h)
    }

    @Test fun plus() = assertEquals(2.0.ms, Duration.ONE + Duration.ONE)

    @Test fun minus() = assertEquals(3.0.s, 5.0.s - 2.0.s)

    @Test fun times() {
        assertEquals(10.ms, 2.ms * 5)
        assertEquals(10.0.ms, 2.0.ms * 5.0)
    }

    @Test fun div() {
        assertEquals(Duration.INDEFINITE, 100.ms / 0)
        assertEquals(Duration.INDEFINITE, 100.0.ms / 0.0)
    }

    @Test fun unaryMinus() = assertEquals(Duration.ONE.negate(), (-1).ms)

    @ExperimentalTime
    @Test fun toKotlinDuration() {
        val aSecond = 1.s.toKotlinDuration()
        assertEquals(1000.0, aSecond.inMilliseconds)
    }

    @ExperimentalTime
    @Test fun toFxDuration() {
        val aSecond = 1.seconds.toFxDuration()
        assertEquals(1000.0, aSecond.toMillis())
    }
}
