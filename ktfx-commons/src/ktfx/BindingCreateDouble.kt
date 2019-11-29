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
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create an [DoubleBinding] with multiple observable [dependencies]. */
fun doubleBindingOf(vararg dependencies: Observable, valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create an [DoubleBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toDoubleBinding(noinline valueProvider: (V?) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toDoubleBinding(noinline valueProvider: (Boolean) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value) }

/** Create an [DoubleBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toDoubleBinding(noinline valueProvider: (Double) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Double) }

/** Create an [DoubleBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toDoubleBinding(noinline valueProvider: (Float) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Float) }

/** Create an [DoubleBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toDoubleBinding(noinline valueProvider: (Int) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Int) }

/** Create an [DoubleBinding] with single observable long dependency. */
inline fun ObservableLongValue.toDoubleBinding(noinline valueProvider: (Long) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(value as Long) }

/** Create an [DoubleBinding] with single observable list dependency. */
inline fun <E> ObservableList<E>.toDoubleBinding(noinline valueProvider: (List<E>) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(this) }

/** Create an [DoubleBinding] with single observable set dependency. */
inline fun <E> ObservableSet<E>.toDoubleBinding(noinline valueProvider: (Set<E>) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(this) }

/** Create an [DoubleBinding] with single observable map dependency. */
inline fun <K, V> ObservableMap<K, V>.toDoubleBinding(noinline valueProvider: (Map<K, V>) -> Double): DoubleBinding =
    doubleBindingOf(this) { valueProvider(this) }
