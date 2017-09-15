@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.beans.Observable
import javafx.beans.binding.*
import java.util.concurrent.Callable

/** Helper function to create boolean binding. */
inline fun booleanBindingOf(noinline func: () -> Boolean, vararg dependencies: Observable): BooleanBinding = Bindings.createBooleanBinding(Callable { func() }, *dependencies)

/** Helper function to create double binding. */
inline fun doubleBindingOf(noinline func: () -> Double, vararg dependencies: Observable): DoubleBinding = Bindings.createDoubleBinding(Callable { func() }, *dependencies)

/** Helper function to create float binding. */
inline fun floatBindingOf(noinline func: () -> Float, vararg dependencies: Observable): FloatBinding = Bindings.createFloatBinding(Callable { func() }, *dependencies)

/** Helper function to create integer binding. */
inline fun intBindingOf(noinline func: () -> Int, vararg dependencies: Observable): IntegerBinding = Bindings.createIntegerBinding(Callable { func() }, *dependencies)

/** Helper function to create long binding. */
inline fun longBindingOf(noinline func: () -> Long, vararg dependencies: Observable): LongBinding = Bindings.createLongBinding(Callable { func() }, *dependencies)

/** Helper function to create custom object binding. */
inline fun <T> objectBindingOf(noinline func: () -> T, vararg dependencies: Observable): ObjectBinding<T> = Bindings.createObjectBinding(Callable { func() }, *dependencies)

/** Helper function to create string binding. */
inline fun stringBindingOf(noinline func: () -> String, vararg dependencies: Observable): StringBinding = Bindings.createStringBinding(Callable { func() }, *dependencies)