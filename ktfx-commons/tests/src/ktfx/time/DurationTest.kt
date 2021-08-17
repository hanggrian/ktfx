package ktfx.time

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

class DurationTest {

    @Test
    fun toDuration() {
        assertEquals(5000.milliseconds, "5000ms".toDuration())
        assertEquals(500.seconds, "500s".toDuration())
        assertEquals(50.minutes, "50m".toDuration())
        assertEquals(5.hours, "5h".toDuration())
    }

    @Test
    fun ms() {
        assertEquals(Duration.millis(5000.0), 5000.milliseconds)
        assertEquals(Duration.millis(5000.0), 5000L.milliseconds)
        assertEquals(Duration.millis(5000.0), 5000.0.milliseconds)
    }

    @Test
    fun s() {
        assertEquals(Duration.seconds(500.0), 500.seconds)
        assertEquals(Duration.seconds(500.0), 500L.seconds)
        assertEquals(Duration.seconds(500.0), 500.0.seconds)
    }

    @Test
    fun m() {
        assertEquals(Duration.minutes(50.0), 50.minutes)
        assertEquals(Duration.minutes(50.0), 50L.minutes)
        assertEquals(Duration.minutes(50.0), 50.0.minutes)
    }

    @Test
    fun h() {
        assertEquals(Duration.hours(5.0), 5.hours)
        assertEquals(Duration.hours(5.0), 5L.hours)
        assertEquals(Duration.hours(5.0), 5.0.hours)
    }

    @Test
    fun plus() = assertEquals(2.0.milliseconds, Duration.ONE + Duration.ONE)

    @Test
    fun minus() = assertEquals(3.0.seconds, 5.0.seconds - 2.0.seconds)

    @Test
    fun times() {
        assertEquals(10.milliseconds, 2.milliseconds * 5)
        assertEquals(10.0.milliseconds, 2.0.milliseconds * 5.0)
    }

    @Test
    fun div() {
        assertEquals(Duration.INDEFINITE, 100.milliseconds / 0)
        assertEquals(Duration.INDEFINITE, 100.0.milliseconds / 0.0)
    }

    @Test
    fun unaryMinus() = assertEquals(Duration.ONE.negate(), (-1).milliseconds)

    @ExperimentalTime
    @Test
    fun toKotlinDuration() {
        val aSecond = 1.seconds.toKotlinDuration()
        assertEquals(1000, aSecond.inWholeMilliseconds)
    }

    @ExperimentalTime
    @Test
    fun toFxDuration() {
        val aSecond = kotlin.time.Duration.seconds(1).toFxDuration()
        assertEquals(1000.0, aSecond.toMillis())
    }
}
