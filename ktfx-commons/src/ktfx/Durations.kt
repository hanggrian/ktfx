@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package ktfx

import javafx.util.Duration

/** Convenient method to add duration with `+` operator. */
inline operator fun Duration.plus(other: Duration): Duration =
    add(other)

/** Convenient method to subtract duration with `-` operator. */
inline operator fun Duration.minus(other: Duration): Duration =
    subtract(other)

/** Convenient method to multiply duration in millis with `*` operator. */
@Deprecated("Not taking units into account.", ReplaceWith("this * this.toMillis()"))
inline operator fun Duration.times(other: Duration): Duration =
    multiply(other)

/** Convenient method to multiply duration in millis with `*` operator. */
inline operator fun Duration.times(n: Double): Duration =
    multiply(n)

/** Convenient method to divide duration in millis with `/` operator. */
@Deprecated("Not taking units into account.", ReplaceWith("this / this.toMillis()"))
inline operator fun Duration.div(other: Duration): Duration =
    divide(other)

/** Convenient method to divide duration in millis with `/` operator. */
inline operator fun Duration.div(n: Double): Duration =
    divide(n)

/** Convenient method to negate duration. */
inline operator fun Duration.unaryMinus(): Duration =
    negate()
