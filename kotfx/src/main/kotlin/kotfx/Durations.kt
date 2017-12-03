@file:Suppress("NOTHING_TO_INLINE", "UNUSED", "DEPRECATION")

package kotfx

import javafx.util.Duration
import javafx.util.Duration.*

inline fun durationOf(time: String): Duration = valueOf(time)
inline fun millisDurationOf(ms: Double): Duration = millis(ms)
inline fun secondsDurationOf(s: Double): Duration = seconds(s)
inline fun minutesDurationOf(m: Double): Duration = minutes(m)
inline fun hoursDurationOf(h: Double): Duration = hours(h)

inline operator fun Duration.plus(other: Duration): Duration = add(other)
inline operator fun Duration.minus(other: Duration): Duration = subtract(other)
inline operator fun Duration.times(other: Duration): Duration = multiply(other)
inline operator fun Duration.times(n: Double): Duration = multiply(n)
inline operator fun Duration.div(other: Duration): Duration = divide(other)
inline operator fun Duration.div(n: Double): Duration = divide(n)