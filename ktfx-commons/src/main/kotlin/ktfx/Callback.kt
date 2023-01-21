@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.util.Callback

/** Create new callback using Kotlin function type. */
inline fun <P, R> callbackOf(noinline callback: (P) -> R?): Callback<P, R> =
    Callback { callback(it) }

/** Converts the object provided into its string form. */
@Suppress("NOTHING_TO_INLINE")
inline operator fun <P, R> Callback<P, R>.invoke(obj: P): R = call(obj)
