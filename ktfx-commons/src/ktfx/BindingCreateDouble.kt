@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue

/** Create an [DoubleBinding] with multiple [Observable] dependencies. */
fun doubleBindingOf(vararg dependencies: Observable, valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create an [DoubleBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toDoubleBinding(noinline valueProvider: (V?) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toDoubleBinding(noinline valueProvider: (Boolean) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toDoubleBinding(noinline valueProvider: (Double) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Double) }

/** Create an [DoubleBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toDoubleBinding(noinline valueProvider: (Float) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Float) }

/** Create an [DoubleBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toDoubleBinding(noinline valueProvider: (Int) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Int) }

/** Create an [DoubleBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toDoubleBinding(noinline valueProvider: (Long) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Long) }
