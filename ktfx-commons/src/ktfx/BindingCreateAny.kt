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

/** Create an [ObjectBinding] with multiple observable [dependencies]. */
fun <T> bindingOf(vararg dependencies: Observable, valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create an [ObjectBinding] of [Callback] with multiple observable [dependencies]. */
inline fun <P, R> callbackBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: (P) -> R?
): ObjectBinding<Callback<P, R>> = bindingOf(*dependencies) { Callback<P, R>(valueProvider) }

/** Create an [ObjectBinding] with single observable dependency. */
inline fun <V, T> ObservableValue<V>.toAny(noinline valueProvider: (V?) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value) }

/** Create an [ObjectBinding] with single observable boolean dependency. */
inline fun <T> ObservableBooleanValue.toAny(noinline valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value) }

/** Create an [ObjectBinding] with single observable double dependency. */
inline fun <T> ObservableDoubleValue.toAny(noinline valueProvider: (Double) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Double) }

/** Create an [ObjectBinding] with single observable float dependency. */
inline fun <T> ObservableFloatValue.toAny(noinline valueProvider: (Float) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Float) }

/** Create an [ObjectBinding] with single observable int dependency. */
inline fun <T> ObservableIntegerValue.toAny(noinline valueProvider: (Int) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Int) }

/** Create an [ObjectBinding] with single observable long dependency. */
inline fun <T> ObservableLongValue.toAny(noinline valueProvider: (Long) -> T?): ObjectBinding<T> =
    bindingOf(this) { valueProvider(value as Long) }
