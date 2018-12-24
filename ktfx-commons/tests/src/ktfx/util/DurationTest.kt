package ktfx.util

import javafx.util.Duration
import ktfx.div
import ktfx.minus
import ktfx.plus
import ktfx.times
import org.junit.Test
import kotlin.test.assertEquals

class DurationTest {

    @Test fun plus() = assertEquals(Duration(2.0), Duration.ONE + Duration.ONE)

    @Test fun minus() = assertEquals(Duration.ZERO, Duration.ONE - Duration.ONE)

    @Test fun times() = assertEquals(Duration(10.0), Duration(2.0) * 5.0)

    @Test fun div() = assertEquals(Duration.INDEFINITE, Duration(100.0) / 0.0)
}