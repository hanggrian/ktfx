@file:Suppress("NOTHING_TO_INLINE")

package ktfx.time

import javafx.util.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit.MILLISECONDS
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

/** Converts this [String] to a duration with the syntax `[number][ms|s|m|h]`. */
public inline fun String.toDuration(): Duration = Duration.valueOf(this)

/**
 * Returns a duration equal to this [Int] number of milliseconds.
 *
 * @see kotlin.time.Duration.milliseconds
 */
public val Int.ms: Duration get() = Duration.millis(toDouble())

/**
 * Returns a duration equal to this [Long] number of milliseconds.
 *
 * @see kotlin.time.Duration.milliseconds
 */
public val Long.ms: Duration get() = Duration.millis(toDouble())

/**
 * Returns a duration equal to this [Double] number of milliseconds.
 *
 * @see kotlin.time.Duration.milliseconds
 */
public inline val Double.ms: Duration get() = Duration.millis(this)

/**
 * Returns a duration equal to this [Int] number of seconds.
 *
 * @see kotlin.time.Duration.seconds
 */
public val Int.s: Duration get() = Duration.seconds(toDouble())

/**
 * Returns a duration equal to this [Long] number of seconds.
 *
 * @see kotlin.time.Duration.seconds
 */
public val Long.s: Duration get() = Duration.seconds(toDouble())

/**
 * Returns a duration equal to this [Double] number of seconds.
 *
 * @see kotlin.time.Duration.seconds
 */
public inline val Double.s: Duration get() = Duration.seconds(this)

/**
 * Returns a duration equal to this [Int] number of minutes.
 *
 * @see kotlin.time.Duration.minutes
 */
public val Int.m: Duration get() = Duration.minutes(toDouble())

/**
 * Returns a duration equal to this [Long] number of minutes.
 *
 * @see kotlin.time.Duration.minutes
 */
public val Long.m: Duration get() = Duration.minutes(toDouble())

/**
 * Returns a duration equal to this [Double] number of minutes.
 *
 * @see kotlin.time.Duration.minutes
 */
public inline val Double.m: Duration get() = Duration.minutes(this)

/**
 * Returns a duration equal to this [Int] number of hours.
 *
 * @see kotlin.time.Duration.hours
 */
public val Int.h: Duration get() = Duration.hours(toDouble())

/**
 * Returns a duration equal to this [Long] number of hours.
 *
 * @see kotlin.time.Duration.hours
 */
public val Long.h: Duration get() = Duration.hours(toDouble())

/**
 * Returns a duration equal to this [Double] number of hours.
 *
 * @see kotlin.time.Duration.hours
 */
public inline val Double.h: Duration get() = Duration.hours(this)

/**
 * Returns a duration whose value is the sum of this and [other] duration values.
 *
 * @see kotlin.time.Duration.plus
 */
public inline operator fun Duration.plus(other: Duration): Duration = add(other)

/**
 * Returns a duration whose value is the difference between this and [other] duration values.
 *
 * @see kotlin.time.Duration.minus
 */
public inline operator fun Duration.minus(other: Duration): Duration = subtract(other)

/**
 * Returns a duration whose value is this duration value multiplied by the given [scale] number.
 *
 * @see kotlin.time.Duration.times
 */
public operator fun Duration.times(scale: Int): Duration = multiply(scale.toDouble())

/**
 * Returns a duration whose value is this duration value multiplied by the given [scale] number.
 *
 * @see kotlin.time.Duration.times
 */
public inline operator fun Duration.times(scale: Double): Duration = multiply(scale)

/**
 * Returns a duration whose value is this duration value divided by the given [scale] number.
 *
 * @see kotlin.time.Duration.div
 */
public operator fun Duration.div(scale: Int): Duration = divide(scale.toDouble())

/**
 * Returns a duration whose value is this duration value divided by the given [scale] number.
 *
 * @see kotlin.time.Duration.div
 */
public inline operator fun Duration.div(scale: Double): Duration = divide(scale)

/**
 * Returns the negative of this value.
 *
 * @see kotlin.time.Duration.unaryMinus
 */
public inline operator fun Duration.unaryMinus(): Duration = negate()

/** Returns this [Duration] as a [kotlin.time.Duration]. */
@ExperimentalTime
public inline fun Duration.toKotlinDuration(): kotlin.time.Duration =
    toMillis().toDuration(MILLISECONDS)

/** Returns this [kotlin.time.Duration] as a JavaFX [Duration]. */
@ExperimentalTime
public inline fun kotlin.time.Duration.toFxDuration(): Duration = Duration(toDouble(MILLISECONDS))
