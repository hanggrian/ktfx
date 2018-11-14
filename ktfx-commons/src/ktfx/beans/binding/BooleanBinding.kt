@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun buildBooleanBinding(
    vararg dependencies: Observable,
    noinline func: () -> Boolean?
): BooleanBinding = Bindings.createBooleanBinding(Callable(func), *dependencies)

/** Helper function to create a custom [BooleanBinding]. */
fun buildBooleanBinding(
    dependencies: Collection<Observable>,
    func: () -> Boolean?
): BooleanBinding = buildBooleanBinding(*dependencies.toTypedArray(), func = func)

/** Creates a boolean binding used to get a member. */
inline fun Any.selectBoolean(vararg steps: String): BooleanBinding = Bindings.selectBoolean(this, *steps)