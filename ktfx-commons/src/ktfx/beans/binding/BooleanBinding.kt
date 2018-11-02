@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings.createBooleanBinding
import javafx.beans.binding.Bindings.selectBoolean
import javafx.beans.binding.BooleanBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun buildBooleanBinding(
    vararg dependencies: Observable,
    noinline func: () -> Boolean?
): BooleanBinding = createBooleanBinding(Callable(func), *dependencies)

/** Creates a boolean binding used to get a member. */
inline fun Any.selectBoolean(vararg steps: String): BooleanBinding = selectBoolean(this, *steps)