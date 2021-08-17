@file:Suppress("NOTHING_TO_INLINE")

package ktfx.time

import javafx.util.Duration
import java.util.concurrent.TimeUnit
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

/** Converts this [String] to a duration with the syntax `[number][ms|s|m|h]`. */
inline fun String.toDuration(): Duration = Duration.valueOf(this)

/**
 * Returns a duration equal to this [Int] number of milliseconds.
 * @see kotlin.time.Duration.milliseconds
 */
val Int.milliseconds: Duration get() = toDouble().milliseconds

/**
 * Returns a duration equal to this [Long] number of milliseconds.
 * @see kotlin.time.Duration.milliseconds
 */
val Long.milliseconds: Duration get() = toDouble().milliseconds

/**
 * Returns a duration equal to this [Double] number of milliseconds.
 * @see kotlin.time.Duration.milliseconds
 */
inline val Double.milliseconds: Duration get() = Duration.millis(this)

/**
 * Returns a duration equal to this [Int] number of seconds.
 * @see kotlin.time.Duration.seconds
 */
val Int.seconds: Duration get() = toDouble().seconds

/**
 * Returns a duration equal to this [Long] number of seconds.
 * @see kotlin.time.Duration.seconds
 */
val Long.seconds: Duration get() = toDouble().seconds

/**
 * Returns a duration equal to this [Double] number of seconds.
 * @see kotlin.time.Duration.seconds
 */
inline val Double.seconds: Duration get() = Duration.seconds(this)

/**
 * Returns a duration equal to this [Int] number of minutes.
 * @see kotlin.time.Duration.minutes
 */
val Int.minutes: Duration get() = toDouble().minutes

/**
 * Returns a duration equal to this [Long] number of minutes.
 * @see kotlin.time.Duration.minutes
 */
val Long.minutes: Duration get() = toDouble().minutes

/**
 * Returns a duration equal to this [Double] number of minutes.
 * @see kotlin.time.Duration.minutes
 */
inline val Double.minutes: Duration get() = Duration.minutes(this)

/**
 * Returns a duration equal to this [Int] number of hours.
 * @see kotlin.time.Duration.hours
 */
val Int.hours: Duration get() = toDouble().hours

/**
 * Returns a duration equal to this [Long] number of hours.
 * @see kotlin.time.Duration.hours
 */
val Long.hours: Duration get() = toDouble().hours

/**
 * Returns a duration equal to this [Double] number of hours.
 * @see kotlin.time.Duration.hours
 */
inline val Double.hours: Duration get() = Duration.hours(this)

/**
 * Returns a duration whose value is the sum of this and [other] duration values.
 * @see kotlin.time.Duration.plus
 */
inline operator fun Duration.plus(other: Duration): Duration = add(other)

/**
 * Returns a duration whose value is the difference between this and [other] duration values.
 * @see kotlin.time.Duration.minus
 */
inline operator fun Duration.minus(other: Duration): Duration = subtract(other)

/**
 * Returns a duration whose value is this duration value multiplied by the given [scale] number.
 * @see kotlin.time.Duration.times
 */
operator fun Duration.times(scale: Int): Duration = multiply(scale.toDouble())

/**
 * Returns a duration whose value is this duration value multiplied by the given [scale] number.
 * @see kotlin.time.Duration.times
 */
inline operator fun Duration.times(scale: Double): Duration = multiply(scale)

/**
 * Returns a duration whose value is this duration value divided by the given [scale] number.
 * @see kotlin.time.Duration.div
 */
operator fun Duration.div(scale: Int): Duration = divide(scale.toDouble())

/**
 * Returns a duration whose value is this duration value divided by the given [scale] number.
 * @see kotlin.time.Duration.div
 */
inline operator fun Duration.div(scale: Double): Duration = divide(scale)

/**
 * Returns the negative of this value.
 * @see kotlin.time.Duration.unaryMinus
 */
inline operator fun Duration.unaryMinus(): Duration = negate()

/** Returns this [Duration] as a [kotlin.time.Duration]. */
@ExperimentalTime
inline fun Duration.toKotlinDuration(): kotlin.time.Duration = toMillis().toDuration(DurationUnit.MILLISECONDS)

/** Returns this [kotlin.time.Duration] as a JavaFX [Duration]. */
@ExperimentalTime
inline fun kotlin.time.Duration.toFxDuration(): Duration = Duration(toDouble(TimeUnit.MILLISECONDS))
