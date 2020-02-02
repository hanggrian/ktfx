@file:JvmMultifileClass
@file:JvmName("BindingKt")

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

/** Create an [ObjectBinding] with multiple [Observable] dependencies. */
inline fun <T> bindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider() }, *dependencies)

/** Create an [ObjectBinding] with single [ObservableValue] dependency. */
inline fun <V, T> ObservableValue<V>.toBinding(crossinline valueProvider: (V?) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value) }, this)

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
inline fun <T> ObservableBooleanValue.toBinding(crossinline valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value) }, this)

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
inline fun <T> ObservableDoubleValue.toBinding(crossinline valueProvider: (Double) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Double) }, this)

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
inline fun <T> ObservableFloatValue.toBinding(crossinline valueProvider: (Float) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Float) }, this)

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
inline fun <T> ObservableIntegerValue.toBinding(crossinline valueProvider: (Int) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Int) }, this)

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
inline fun <T> ObservableLongValue.toBinding(crossinline valueProvider: (Long) -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable { valueProvider(value as Long) }, this)
