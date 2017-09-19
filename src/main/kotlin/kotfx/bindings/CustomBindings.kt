@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.*
import java.util.concurrent.Callable

/** Helper function to create a custom boolean binding. */
inline fun customBooleanBinding(vararg dependencies: Observable, noinline func: () -> Boolean): BooleanBinding = Bindings.createBooleanBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom double binding. */
inline fun customDoubleBinding(vararg dependencies: Observable, noinline func: () -> Double): DoubleBinding = Bindings.createDoubleBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom float binding. */
inline fun customFloatBinding(vararg dependencies: Observable, noinline func: () -> Float): FloatBinding = Bindings.createFloatBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom integer binding. */
inline fun customIntBinding(vararg dependencies: Observable, noinline func: () -> Int): IntegerBinding = Bindings.createIntegerBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom long binding. */
inline fun customLongBinding(vararg dependencies: Observable, noinline func: () -> Long): LongBinding = Bindings.createLongBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom object binding. */
inline fun <T> customBinding(vararg dependencies: Observable, noinline func: () -> T): ObjectBinding<T> = Bindings.createObjectBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom string binding. */
inline fun customStringBinding(vararg dependencies: Observable, noinline func: () -> String): StringBinding = Bindings.createStringBinding(Callable { func() }, *dependencies)