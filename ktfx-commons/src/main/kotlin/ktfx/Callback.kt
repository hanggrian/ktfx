@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.util.Callback

/** Converts the object provided into its string form. */
@Suppress("NOTHING_TO_INLINE")
inline operator fun <P, R> Callback<P, R>.invoke(obj: P): R = call(obj)
