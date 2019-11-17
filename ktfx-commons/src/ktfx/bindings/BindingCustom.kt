@file:JvmMultifileClass
@file:JvmName("BindingKt")

package ktfx.bindings

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.util.Callback

/** Helper function to create a custom [ObjectBinding]. */
fun <T> bindingOf(vararg dependencies: Observable, func: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(func), *dependencies)

/** Helper function to create a custom [BooleanBinding]. */
fun booleanBindingOf(vararg dependencies: Observable, func: () -> Boolean?): BooleanBinding =
    Bindings.createBooleanBinding(Callable(func), *dependencies)

/** Helper function to create a custom [StringBinding]. */
fun stringBindingOf(vararg dependencies: Observable, func: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(func), *dependencies)

/** Helper function to create a custom [DoubleBinding]. */
fun doubleBindingOf(vararg dependencies: Observable, func: () -> Double?): DoubleBinding =
    Bindings.createDoubleBinding(Callable(func), *dependencies)

/** Helper function to create a custom [FloatBinding]. */
fun floatBindingOf(vararg dependencies: Observable, func: () -> Float?): FloatBinding =
    Bindings.createFloatBinding(Callable(func), *dependencies)

/** Helper function to create a custom [IntegerBinding]. */
fun intBindingOf(vararg dependencies: Observable, func: () -> Int?): IntegerBinding =
    Bindings.createIntegerBinding(Callable(func), *dependencies)

/** Helper function to create a custom [LongBinding]. */
fun longBindingOf(vararg dependencies: Observable, func: () -> Long?): LongBinding =
    Bindings.createLongBinding(Callable(func), *dependencies)

/** Helper function to create a custom [ObjectBinding] of [Callback]. */
fun <P, R> callbackBindingOf(vararg dependencies: Observable, func: (P) -> R?): ObjectBinding<Callback<P, R>> =
    Bindings.createObjectBinding<Callback<P, R>>(Callable<Callback<P, R>> { Callback<P, R>(func) }, *dependencies)

/** Creates a string binding used to get a member. */
fun Any.selectString(vararg steps: String): StringBinding =
    Bindings.selectString(this, *steps)

/** Creates an object binding used to get a member. */
fun <T> Any.select(vararg steps: String): ObjectBinding<T> =
    Bindings.select(this, *steps)

/** Creates a boolean binding used to get a member. */
fun Any.selectBoolean(vararg steps: String): BooleanBinding =
    Bindings.selectBoolean(this, *steps)

/** Creates a double binding used to get a member. */
fun Any.selectDouble(vararg steps: String): DoubleBinding =
    Bindings.selectDouble(this, *steps)

/** Creates a float binding used to get a member. */
fun Any.selectFloat(vararg steps: String): FloatBinding =
    Bindings.selectFloat(this, *steps)

/** Creates an integer binding used to get a member. */
fun Any.selectInt(vararg steps: String): IntegerBinding =
    Bindings.selectInteger(this, *steps)

/** Creates a long binding used to get a member. */
fun Any.selectLong(vararg steps: String): LongBinding =
    Bindings.selectLong(this, *steps)
