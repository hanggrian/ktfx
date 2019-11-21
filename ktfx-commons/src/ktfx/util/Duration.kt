@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package ktfx.util

import javafx.util.Duration

/** Converts double value into duration in milliseconds. */
val Double.millis: Duration
    get() = Duration.millis(this)

/** Converts double value into duration in seconds. */
val Double.seconds: Duration
    get() = Duration.seconds(this)

/** Converts double value into duration in minutes. */
val Double.minutes: Duration
    get() = Duration.minutes(this)

/** Converts double value into duration in hours. */
val Double.hours: Duration
    get() = Duration.hours(this)

/** Converts any number value into duration in milliseconds. */
inline val Number.millis: Duration
    get() = toDouble().millis

/** Converts any number value into duration in seconds. */
inline val Number.seconds: Duration
    get() = toDouble().seconds

/** Converts any number value into duration in minutes. */
inline val Number.minutes: Duration
    get() = toDouble().minutes

/** Converts any number value into duration in hours. */
inline val Number.hours: Duration
    get() = toDouble().hours

/** Add duration with `+` operator. */
inline operator fun Duration.plus(other: Duration): Duration =
    add(other)

/** Subtract duration with `-` operator. */
inline operator fun Duration.minus(other: Duration): Duration =
    subtract(other)

/** Multiply duration with `*` operator. */
inline operator fun Duration.times(n: Double): Duration =
    multiply(n)

/** Divide duration with `/` operator. */
inline operator fun Duration.div(n: Double): Duration =
    divide(n)

/** Negate duration. */
inline operator fun Duration.unaryMinus(): Duration =
    negate()

/** Multiply duration with `*` operator. */
inline operator fun Duration.times(n: Number): Duration =
    times(n.toDouble())

/** Divide duration with `/` operator. */
inline operator fun Duration.div(n: Number): Duration =
    div(n.toDouble())
