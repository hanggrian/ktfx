@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package ktfx

import javafx.util.Duration

/** Converts double value into duration in milliseconds. */
val Double.millis: Duration
    get() = Duration.millis(this)

/** Converts int value into duration in milliseconds. */
inline val Int.millis: Duration
    get() = toDouble().millis

/** Converts double value into duration in seconds. */
val Double.seconds: Duration
    get() = Duration.seconds(this)

/** Converts int value into duration in seconds. */
inline val Int.seconds: Duration
    get() = toDouble().seconds

/** Converts double value into duration in minutes. */
val Double.minutes: Duration
    get() = Duration.minutes(this)

/** Converts int value into duration in minutes. */
inline val Int.minutes: Duration
    get() = toDouble().minutes

/** Converts double value into duration in hours. */
val Double.hours: Duration
    get() = Duration.hours(this)

/** Converts int value into duration in hours. */
inline val Int.hours: Duration
    get() = toDouble().hours

/** Convenient method to add duration with `+` operator. */
inline operator fun Duration.plus(other: Duration): Duration =
    add(other)

/** Convenient method to subtract duration with `-` operator. */
inline operator fun Duration.minus(other: Duration): Duration =
    subtract(other)

/** Convenient method to multiply duration in millis with `*` operator. */
inline operator fun Duration.times(n: Double): Duration =
    multiply(n)

/** Convenient method to divide duration in millis with `/` operator. */
inline operator fun Duration.div(n: Double): Duration =
    divide(n)

/** Convenient method to negate duration. */
inline operator fun Duration.unaryMinus(): Duration =
    negate()
