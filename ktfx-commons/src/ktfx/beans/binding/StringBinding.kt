@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings.createStringBinding
import javafx.beans.binding.StringBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [StringBinding]. */
inline fun stringBindingOf(vararg dependencies: Observable, noinline func: () -> String): StringBinding =
    createStringBinding(Callable(func), *dependencies)