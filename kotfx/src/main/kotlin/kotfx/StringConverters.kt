@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.util.StringConverter

/** Creates a new string converter using [fromString] and optional [toString]. */
@JvmOverloads
inline fun <T> stringConverterOf(
        noinline toString: (T) -> String = { it.toString() },
        noinline fromString: (String) -> T
): StringConverter<T> = object : StringConverter<T>() {
    override fun toString(t: T): String = toString(t)
    override fun fromString(s: String): T = fromString(s)
}