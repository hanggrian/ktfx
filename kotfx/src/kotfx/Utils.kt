@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package kotfx

import javafx.util.Duration
import javafx.util.StringConverter

/** Creates a new string converter using [_fromString] and optional [_toString]. */
inline fun <T> stringConverterOf(
    noinline _toString: (T?) -> String = { it.toString() },
    noinline _fromString: (String) -> T?
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T?): String = _toString(t)
    override fun fromString(s: String): T? = _fromString(s)
}

/** Converts JavaFX's pair to Kotlin's. */
inline fun <K, V> javafx.util.Pair<K, V>.toKotlinPair(): Pair<K, V> = Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <K, V> Pair<K, V>.toFXPair(): javafx.util.Pair<K, V> = javafx.util.Pair(first, second)

/** Convenient method to add duration with `+` operator. */
inline operator fun Duration.plus(other: Duration): Duration = add(other)

/** Convenient method to subtract duration with `-` operator. */
inline operator fun Duration.minus(other: Duration): Duration = subtract(other)

/** Convenient method to multiply duration with `*` operator. */
inline operator fun Duration.times(other: Duration): Duration = multiply(other)

/** Convenient method to multiply duration in millis with `*` operator. */
inline operator fun Duration.times(n: Double): Duration = multiply(n)

/** Convenient method to divide duration with `/` operator. */
inline operator fun Duration.div(other: Duration): Duration = divide(other)

/** Convenient method to divide duration in millis with `/` operator. */
inline operator fun Duration.div(n: Double): Duration = divide(n)