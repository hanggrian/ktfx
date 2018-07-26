@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings.createStringBinding
import javafx.beans.binding.Bindings.selectString
import javafx.beans.binding.StringBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [StringBinding]. */
inline fun stringBindingOf(
    vararg dependencies: Observable,
    noinline func: () -> String?
): StringBinding = createStringBinding(Callable(func), *dependencies)

/** Creates a string binding used to get a member. */
inline fun Any.selectString(vararg steps: String): StringBinding = selectString(this, *steps)