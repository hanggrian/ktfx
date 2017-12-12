@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.util.Callback
import javafx.util.StringConverter

/** Creates a new callback using Kotlin's function types. */
inline fun <P, R> callbackOf(noinline converter: (P) -> R): Callback<P, R> = Callback(converter)

/** Creates a new string converter using [convertFromString] and optional [convertToString]. */
@JvmOverloads
inline fun <T> stringConverterOf(
        noinline convertFromString: (String) -> T,
        noinline convertToString: (T) -> String = { it.toString() }
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T): String = convertToString(t)
    override fun fromString(s: String): T = convertFromString(s)
}