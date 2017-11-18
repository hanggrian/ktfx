@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.util.StringConverter

/** Converts JavaFX's pair to Kotlin's. */
inline fun <K, V> javafx.util.Pair<K, V>.toKotlinPair(): Pair<K, V> = Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <K, V> Pair<K, V>.toFXPair(): javafx.util.Pair<K, V> = javafx.util.Pair(first, second)

/** Creates a new string converter using [fromString] and optional [toString]. */
@JvmOverloads
inline fun <T> stringConverterOf(
        noinline toString: (T) -> String = { it.toString() },
        noinline fromString: (String) -> T
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T): String = toString(t)
    override fun fromString(s: String): T = fromString(s)
}