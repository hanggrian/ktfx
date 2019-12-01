@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.beans.Observable
import javafx.beans.binding.ObjectBinding
import javafx.util.Callback
import ktfx.bindingOf

/** Create new callback using Kotlin function type. */
fun <P, R> callbackOf(callback: (P) -> R?): Callback<P, R> = Callback<P, R>(callback)

/** Create an [ObjectBinding] of [Callback] with multiple [Observable] dependencies. */
inline fun <P, R> callbackBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: (P) -> R?
): ObjectBinding<Callback<P, R>> = bindingOf(*dependencies) { callbackOf(valueProvider) }

/** Converts the object provided into its string form. */
inline operator fun <P, R> Callback<P, R>.invoke(obj: P): R = call(obj)
