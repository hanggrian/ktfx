@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create an [IntegerBinding] with multiple observable [dependencies]. */
fun intBindingOf(vararg dependencies: Observable, valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create an [IntegerBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toIntBinding(noinline valueProvider: (V?) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toIntBinding(noinline valueProvider: (Boolean) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toIntBinding(noinline valueProvider: (Double) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Double) }

/** Create an [IntegerBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toIntBinding(noinline valueProvider: (Float) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Float) }

/** Create an [IntegerBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toIntBinding(noinline valueProvider: (Int) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Int) }

/** Create an [IntegerBinding] with single observable long dependency. */
inline fun ObservableLongValue.toIntBinding(noinline valueProvider: (Long) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Long) }

/** Create an [IntegerBinding] with single observable list dependency. */
inline fun <E> ObservableList<E>.toIntBinding(noinline valueProvider: (List<E>) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(this) }

/** Create an [IntegerBinding] with single observable set dependency. */
inline fun <E> ObservableSet<E>.toIntBinding(noinline valueProvider: (Set<E>) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(this) }

/** Create an [IntegerBinding] with single observable map dependency. */
inline fun <K, V> ObservableMap<K, V>.toIntBinding(noinline valueProvider: (Map<K, V>) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(this) }
