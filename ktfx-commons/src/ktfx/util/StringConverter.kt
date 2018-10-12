@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.util.StringConverter

/** Converts the object provided into its string form. */
inline operator fun <T> StringConverter<T>.invoke(obj: T): String = toString(obj)

/** Converts the string provided into an object defined by the specific converter. */
inline operator fun <T> StringConverter<T>.invoke(s: String): T = fromString(s)