@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create a [DoubleBinding] with multiple [Observable] dependencies. */
inline fun doubleBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create a [DoubleBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toDoubleBinding(noinline valueProvider: (V?) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value) }, this)

/** Create a [DoubleBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toDoubleBinding(noinline valueProvider: (Boolean) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value) }, this)

/** Create a [DoubleBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toDoubleBinding(noinline valueProvider: (Double) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [DoubleBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toDoubleBinding(noinline valueProvider: (Float) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [DoubleBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toDoubleBinding(noinline valueProvider: (Int) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [DoubleBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toDoubleBinding(noinline valueProvider: (Long) -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable { valueProvider(value as Long) }, this)
