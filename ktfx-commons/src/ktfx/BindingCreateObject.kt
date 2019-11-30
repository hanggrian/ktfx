@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue
import javafx.util.Callback

/** Create an [ObjectBinding] with multiple [Observable] dependencies. */
fun <T> bindingOf(vararg dependencies: Observable, valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create an [ObjectBinding] of [Callback] with multiple [Observable] dependencies. */
inline fun <P, R> callbackBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: (P) -> R?
): ObjectBinding<Callback<P, R>> = bindingOf(*dependencies) { Callback<P, R>(valueProvider) }

/** Create an [ObjectBinding] with single [ObservableValue] dependency. */
inline fun <V, T> ObservableValue<V>.toBinding(noinline valueProvider: (V?) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value) }

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
inline fun <T> ObservableBooleanValue.toBinding(noinline valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value) }

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
inline fun <T> ObservableDoubleValue.toBinding(noinline valueProvider: (Double) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Double) }

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
inline fun <T> ObservableFloatValue.toBinding(noinline valueProvider: (Float) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Float) }

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
inline fun <T> ObservableIntegerValue.toBinding(noinline valueProvider: (Int) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Int) }

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
inline fun <T> ObservableLongValue.toBinding(noinline valueProvider: (Long) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Long) }
