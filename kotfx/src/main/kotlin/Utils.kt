@file:Suppress("NOTHING_TO_INLINE", "UNUSED", "DEPRECATION")

package kotfx

import javafx.util.Callback
import javafx.util.Duration
import javafx.util.StringConverter

/** Creates a new callback using Kotlin's function types. */
inline fun <P, R> callback(noinline converter: (P) -> R): Callback<P, R> = Callback(converter)

/** Creates a new string converter using [convertFromString] and optional [convertToString]. */
@JvmOverloads
inline fun <T> stringConverter(
        noinline convertFromString: (String) -> T,
        noinline convertToString: (T) -> String = { it.toString() }
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T): String = convertToString(t)
    override fun fromString(s: String): T = convertFromString(s)
}

/** Converts JavaFX's pair to Kotlin's. */
inline fun <K, V> javafx.util.Pair<K, V>.toKotlinPair(): Pair<K, V> = Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <K, V> Pair<K, V>.toFXPair(): javafx.util.Pair<K, V> = javafx.util.Pair(first, second)

inline operator fun Duration.plus(other: Duration): Duration = add(other)
inline operator fun Duration.minus(other: Duration): Duration = subtract(other)
inline operator fun Duration.times(other: Duration): Duration = multiply(other)
inline operator fun Duration.times(n: Double): Duration = multiply(n)
inline operator fun Duration.div(other: Duration): Duration = divide(other)
inline operator fun Duration.div(n: Double): Duration = divide(n)