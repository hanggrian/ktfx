@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.util.StringConverter

/** Creates a new string converter using [convertFromString] and optional [convertToString]. */
@JvmOverloads
inline fun <T> stringConverterOf(
        noinline convertFromString: (String) -> T,
        noinline convertToString: (T) -> String = { it.toString() }
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T): String = convertToString(t)
    override fun fromString(s: String): T = convertFromString(s)
}