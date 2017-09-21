@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.*
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> Boolean): BooleanBinding = Bindings.createBooleanBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [DoubleBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> Double): DoubleBinding = Bindings.createDoubleBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [FloatBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> Float): FloatBinding = Bindings.createFloatBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> Int): IntegerBinding = Bindings.createIntegerBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [LongBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> Long): LongBinding = Bindings.createLongBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> bindingOf(vararg dependencies: Observable, noinline func: () -> T): ObjectBinding<T> = Bindings.createObjectBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [StringBinding]. */
inline fun bindingOf(vararg dependencies: Observable, noinline func: () -> String): StringBinding = Bindings.createStringBinding(Callable { func() }, *dependencies)