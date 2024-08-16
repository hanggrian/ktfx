package ktfx.time

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class DurationTest {
    @Test
    fun toDuration() {
        assertEquals(5000.0.ms, "5000ms".toDuration())
        assertEquals(500.0.s, "500s".toDuration())
        assertEquals(50.0.m, "50m".toDuration())
        assertEquals(5.0.h, "5h".toDuration())
    }

    @Test
    fun ms() {
        assertEquals(Duration.millis(2500.0), 2500.ms)
        assertEquals(Duration.millis(5000.0), 5000L.ms)
    }

    @Test
    fun s() {
        assertEquals(Duration.seconds(250.0), 250.s)
        assertEquals(Duration.seconds(500.0), 500L.s)
    }

    @Test
    fun m() {
        assertEquals(Duration.minutes(25.0), 25.m)
        assertEquals(Duration.minutes(50.0), 50L.m)
    }

    @Test
    fun h() {
        assertEquals(Duration.hours(2.0), 2.h)
        assertEquals(Duration.hours(5.0), 5L.h)
    }

    @Test
    fun plus() = assertEquals(2.0.ms, Duration.ONE + Duration.ONE)

    @Test
    fun minus() = assertEquals(3.0.s, 5.0.s - 2.0.s)

    @Test
    fun times() {
        assertEquals(10.ms, 2.ms * 5)
        assertEquals(10.0.ms, 2.0.ms * 5.0)
    }

    @Test
    fun div() {
        assertEquals(Duration.INDEFINITE, 100.ms / 0)
        assertEquals(Duration.INDEFINITE, 100.0.ms / 0.0)
    }

    @Test
    fun unaryMinus() = assertEquals(Duration.ONE.negate(), -(1.ms))

    @Test
    fun toKotlinDuration() = assertEquals(1000, 1.s.toKotlinDuration().inWholeMilliseconds)

    @Test
    fun toFxDuration() = assertEquals(1000.0, 1.seconds.toFxDuration().toMillis())
}
