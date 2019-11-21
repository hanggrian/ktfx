@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableValue
import javafx.util.Callback
import java.util.concurrent.Callable

/** Create an [ObjectBinding] with multiple [dependencies]. */
fun <T> bindingOf(vararg dependencies: Observable, valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create an [BooleanBinding] with multiple [dependencies]. */
fun booleanBindingOf(vararg dependencies: Observable, valueProvider: () -> Boolean?): BooleanBinding =
    Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create an [StringBinding] with multiple [dependencies]. */
fun stringBindingOf(vararg dependencies: Observable, valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create an [DoubleBinding] with multiple [dependencies]. */
fun doubleBindingOf(vararg dependencies: Observable, valueProvider: () -> Double?): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create an [FloatBinding] with multiple [dependencies]. */
fun floatBindingOf(vararg dependencies: Observable, valueProvider: () -> Float?): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create an [IntegerBinding] with multiple [dependencies]. */
fun intBindingOf(vararg dependencies: Observable, valueProvider: () -> Int?): IntegerBinding =
    Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create an [LongBinding] with multiple [dependencies]. */
fun longBindingOf(vararg dependencies: Observable, valueProvider: () -> Long?): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create an [ObjectBinding] of [Callback] with multiple [dependencies]. */
inline fun <P, R> callbackBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: (P) -> R?
): ObjectBinding<Callback<P, R>> = bindingOf(*dependencies) { Callback<P, R>(valueProvider) }

/** Create an [ObjectBinding] with single dependency. */
inline fun <V, T> ObservableValue<V>.toBinding(noinline valueProvider: (V) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value) }

/** Create an [BooleanBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toBooleanBinding(noinline valueProvider: (V) -> Boolean?): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toStringBinding(noinline valueProvider: (V) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toDoubleBinding(noinline valueProvider: (V) -> Double?): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toFloatBinding(noinline valueProvider: (V) -> Float?): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toIntBinding(noinline valueProvider: (V) -> Int?): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [LongBinding] with single dependency. */
inline fun <V> ObservableValue<V>.toLongBinding(noinline valueProvider: (V) -> Long?): LongBinding =
    longBindingOf(this) { valueProvider(value) }

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