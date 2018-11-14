@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> buildBinding(
    vararg dependencies: Observable,
    noinline func: () -> T?
): ObjectBinding<T> = Bindings.createObjectBinding<T>(Callable(func), *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
fun <T> buildBinding(
    dependencies: Collection<Observable>,
    func: () -> T?
): ObjectBinding<T> = buildBinding(*dependencies.toTypedArray(), func = func)

/** Creates an object binding used to get a member. */
inline fun <T> Any.select(vararg steps: String): ObjectBinding<T> = Bindings.select(this, *steps)