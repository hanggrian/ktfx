@file:JvmMultifileClass
@file:JvmName("DurationKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.time

import javafx.util.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

/** Converts this [String] to a [Duration] with the syntax `[number][ms|s|m|h]`. */
fun String.toDuration(): Duration = Duration.valueOf(this)

/** Returns a [Duration] equal to this [Int] number of milliseconds. */
val Int.ms: Duration get() = toDouble().ms

/** Returns a [Duration] equal to this [Long] number of milliseconds. */
val Long.ms: Duration get() = toDouble().ms

/** Returns a [Duration] equal to this [Double] number of milliseconds. */
inline val Double.ms: Duration get() = Duration.millis(this)

/** Returns a [Duration] equal to this [Int] number of seconds. */
val Int.s: Duration get() = toDouble().s

/** Returns a [Duration] equal to this [Long] number of seconds. */
val Long.s: Duration get() = toDouble().s

/** Returns a [Duration] equal to this [Double] number of seconds. */
inline val Double.s: Duration get() = Duration.seconds(this)

/** Returns a [Duration] equal to this [Int] number of minutes. */
val Int.m: Duration get() = toDouble().m

/** Returns a [Duration] equal to this [Long] number of minutes. */
val Long.m: Duration get() = toDouble().m

/** Returns a [Duration] equal to this [Double] number of minutes. */
inline val Double.m: Duration get() = Duration.minutes(this)

/** Returns a [Duration] equal to this [Int] number of hours. */
val Int.h: Duration get() = toDouble().h

/** Returns a [Duration] equal to this [Long] number of hours. */
val Long.h: Duration get() = toDouble().h

/** Returns a [Duration] equal to this [Double] number of hours. */
inline val Double.h: Duration get() = Duration.hours(this)

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

/** Returns this [Duration] as a [kotlin.time.Duration]. */
@ExperimentalTime
inline fun Duration.toKotlinDuration(): kotlin.time.Duration = toMillis().toDuration(DurationUnit.MILLISECONDS)

/** Returns this [kotlin.time.Duration] as an JavaFX [Duration]. */
@ExperimentalTime
inline fun kotlin.time.Duration.toFxDuration(): Duration = Duration(inMilliseconds)
