@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package ktfx

import javafx.util.Duration

/**
 * Converts double value into duration in milliseconds.
 *
 * @see Duration.millis
 */
val Double.millis: Duration
    get() = Duration.millis(this)

/**
 * Converts double value into duration in seconds.
 *
 * @see Duration.seconds
 */
val Double.seconds: Duration
    get() = Duration.seconds(this)

/**
 * Converts double value into duration in minutes.
 *
 * @see Duration.minutes
 */
val Double.minutes: Duration
    get() = Duration.minutes(this)

/**
 * Converts double value into duration in hours.
 *
 * @see Duration.hours
 */
val Double.hours: Duration
    get() = Duration.hours(this)

/**
 * Convenient method to add duration with `+` operator.
 *
 * @see Duration.add
 */
inline operator fun Duration.plus(other: Duration): Duration =
    add(other)

/**
 * Convenient method to subtract duration with `-` operator.
 *
 * @see Duration.subtract
 */
inline operator fun Duration.minus(other: Duration): Duration =
    subtract(other)

/**
 * Convenient method to multiply duration in millis with `*` operator.
 *
 * @see Duration.multiply
 */
inline operator fun Duration.times(n: Double): Duration =
    multiply(n)

/**
 * Convenient method to divide duration in millis with `/` operator.
 *
 * @see Duration.divide
 */
inline operator fun Duration.div(n: Double): Duration =
    divide(n)

/**
 * Convenient method to negate duration.
 *
 * @see Duration.negate
 */
inline operator fun Duration.unaryMinus(): Duration =
    negate()
