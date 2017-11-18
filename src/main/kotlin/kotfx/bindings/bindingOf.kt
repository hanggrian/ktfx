@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.*
import javafx.beans.binding.Bindings.*
import java.util.concurrent.Callable

/** Helper function to create a custom [BooleanBinding]. */
inline fun booleanBindingOf(vararg dependencies: Observable, noinline func: () -> Boolean): BooleanBinding = createBooleanBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [DoubleBinding]. */
inline fun doubleBindingOf(vararg dependencies: Observable, noinline func: () -> Double): DoubleBinding = createDoubleBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [FloatBinding]. */
inline fun floatBindingOf(vararg dependencies: Observable, noinline func: () -> Float): FloatBinding = createFloatBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
inline fun intBindingOf(vararg dependencies: Observable, noinline func: () -> Int): IntegerBinding = createIntegerBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [LongBinding]. */
inline fun longBindingOf(vararg dependencies: Observable, noinline func: () -> Long): LongBinding = createLongBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> bindingOf(vararg dependencies: Observable, noinline func: () -> T?): ObjectBinding<T?> = createObjectBinding(Callable { func() }, *dependencies)

/** Helper function to create a custom [StringBinding]. */
inline fun stringBindingOf(vararg dependencies: Observable, noinline func: () -> String): StringBinding = createStringBinding(Callable { func() }, *dependencies)