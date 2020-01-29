@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.util.Duration

/** Converts double value into duration in milliseconds. */
val Double.millis: Duration get() = Duration.millis(this)

/** Converts any number value into duration in milliseconds. */
val Number.millis: Duration get() = toDouble().millis

/** Converts double value into duration in seconds. */
val Double.seconds: Duration get() = Duration.seconds(this)

/** Converts any number value into duration in seconds. */
val Number.seconds: Duration get() = toDouble().seconds

/** Converts double value into duration in minutes. */
val Double.minutes: Duration get() = Duration.minutes(this)

/** Converts any number value into duration in minutes. */
val Number.minutes: Duration get() = toDouble().minutes

/** Converts double value into duration in hours. */
val Double.hours: Duration get() = Duration.hours(this)

/** Converts any number value into duration in hours. */
val Number.hours: Duration get() = toDouble().hours

/** Add duration with `+` operator. */
inline operator fun Duration.plus(other: Duration): Duration = add(other)

/** Subtract duration with `-` operator. */
inline operator fun Duration.minus(other: Duration): Duration = subtract(other)

/** Multiply duration with `*` operator. */
inline operator fun Duration.times(n: Double): Duration = multiply(n)

/** Multiply duration with `*` operator. */
inline operator fun Duration.times(n: Int): Duration = this * n.toDouble()

/** Divide duration with `/` operator. */
inline operator fun Duration.div(n: Double): Duration = divide(n)

/** Divide duration with `/` operator. */
inline operator fun Duration.div(n: Int): Duration = this / n.toDouble()

/** Negate duration. */
inline operator fun Duration.unaryMinus(): Duration = negate()
