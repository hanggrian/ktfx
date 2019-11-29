@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.LongBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create an [LongBinding] with multiple observable [dependencies]. */
fun longBindingOf(vararg dependencies: Observable, valueProvider: () -> Long): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create an [LongBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toLongBinding(noinline valueProvider: (V?) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create an [LongBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toLongBinding(noinline valueProvider: (Boolean) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create an [LongBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toLongBinding(noinline valueProvider: (Double) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Double) }

/** Create an [LongBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toLongBinding(noinline valueProvider: (Float) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Float) }

/** Create an [LongBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toLongBinding(noinline valueProvider: (Int) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Int) }

/** Create an [LongBinding] with single observable long dependency. */
inline fun ObservableLongValue.toLongBinding(noinline valueProvider: (Long) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Long) }

/** Create an [LongBinding] with single observable list dependency. */
inline fun <E> ObservableList<E>.toLongBinding(noinline valueProvider: (List<E>) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(this) }

/** Create an [LongBinding] with single observable set dependency. */
inline fun <E> ObservableSet<E>.toLongBinding(noinline valueProvider: (Set<E>) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(this) }

/** Create an [LongBinding] with single observable map dependency. */
inline fun <K, V> ObservableMap<K, V>.toLongBinding(noinline valueProvider: (Map<K, V>) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(this) }
