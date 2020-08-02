@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create a [BooleanBinding] with multiple [Observable] dependencies. */
inline fun booleanBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create a [BooleanBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toBooleanBinding(noinline valueProvider: (V?) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value) }, this)

/** Create a [BooleanBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toBooleanBinding(noinline valueProvider: (Boolean) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value) }, this)

/** Create a [BooleanBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toBooleanBinding(noinline valueProvider: (Double) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [BooleanBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toBooleanBinding(noinline valueProvider: (Float) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [BooleanBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toBooleanBinding(noinline valueProvider: (Int) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [BooleanBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toBooleanBinding(noinline valueProvider: (Long) -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable { valueProvider(value as Long) }, this)
