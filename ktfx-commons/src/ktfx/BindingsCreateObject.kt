@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create an [ObjectBinding] with multiple [Observable] dependencies. */
inline fun <T> bindingOf(vararg dependencies: Observable, noinline valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create an [ObjectBinding] with single [ObservableObjectValue] dependency. */
inline fun <V, T> ObservableObjectValue<V>.toBinding(noinline valueProvider: (V?) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value) }, this)

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
inline fun <T> ObservableBooleanValue.toBinding(noinline valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value) }, this)

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
inline fun <T> ObservableDoubleValue.toBinding(noinline valueProvider: (Double) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Double) }, this)

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
inline fun <T> ObservableFloatValue.toBinding(noinline valueProvider: (Float) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Float) }, this)

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
inline fun <T> ObservableIntegerValue.toBinding(noinline valueProvider: (Int) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Int) }, this)

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
inline fun <T> ObservableLongValue.toBinding(noinline valueProvider: (Long) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Long) }, this)
