@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.util.Callback

/** Converts the object provided into its string form. */
inline operator fun <P, R> Callback<P, R>.invoke(obj: P): R =
    call(obj)

/** Helper function to create a custom [ObjectBinding]. */
fun <P, R> callbackBindingOf(vararg dependencies: Observable, func: (P) -> R?): ObjectBinding<Callback<P, R>> =
    Bindings.createObjectBinding<Callback<P, R>>(Callable<Callback<P, R>> { Callback<P, R>(func) }, *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
inline fun <P, R> callbackBindingOf(
    dependencies: Collection<Observable>,
    noinline func: (P) -> R?
): ObjectBinding<Callback<P, R>> = callbackBindingOf(*dependencies.toTypedArray(), func = func)
