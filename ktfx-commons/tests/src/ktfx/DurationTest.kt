package ktfx

import javafx.util.Duration
import kotlin.test.Test
import kotlin.test.assertEquals

class DurationTest {

    @Test
    fun millis() = assertEquals(Duration.millis(5000.0), 5000.0.millis)

    @Test
    fun seconds() = assertEquals(Duration.seconds(500.0), 500.0.seconds)

    @Test
    fun minutes() = assertEquals(Duration.minutes(50.0), 50.0.minutes)

    @Test
    fun hours() = assertEquals(Duration.hours(5.0), 5.0.hours)

    @Test
    fun plus() = assertEquals(2.0.millis, Duration.ONE + Duration.ONE)

    @Test
    fun minus() = assertEquals(3.0.seconds, 5.0.seconds - 2.0.seconds)

    @Test
    fun times() = assertEquals(10.0.millis, 2.0.millis * 5.0)

    @Test
    fun div() = assertEquals(Duration.INDEFINITE, 100.0.millis / 0.0)
}