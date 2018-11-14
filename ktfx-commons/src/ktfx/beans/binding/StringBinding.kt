@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.StringBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [StringBinding]. */
inline fun buildStringBinding(
    vararg dependencies: Observable,
    noinline func: () -> String?
): StringBinding = Bindings.createStringBinding(Callable(func), *dependencies)

/** Helper function to create a custom [StringBinding]. */
inline fun buildStringBinding(
    dependencies: Collection<Observable>,
    noinline func: () -> String?
): StringBinding = buildStringBinding(*dependencies.toTypedArray(), func = func)

/** Creates a string binding used to get a member. */
inline fun Any.selectString(vararg steps: String): StringBinding = Bindings.selectString(this, *steps)