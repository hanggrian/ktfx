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

/** Create an [DoubleBinding] with multiple observable [dependencies]. */
fun doubleBindingOf(vararg dependencies: Observable, valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create an [DoubleBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toDouble(noinline valueProvider: (V?) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toDouble(noinline valueProvider: (Boolean) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toDouble(noinline valueProvider: (Double) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Double) }

/** Create an [DoubleBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toDouble(noinline valueProvider: (Float) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Float) }

/** Create an [DoubleBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toDouble(noinline valueProvider: (Int) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Int) }

/** Create an [DoubleBinding] with single observable long dependency. */
inline fun ObservableLongValue.toDouble(noinline valueProvider: (Long) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Long) }
