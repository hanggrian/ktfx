@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create an [StringBinding] with multiple observable [dependencies]. */
fun stringBindingOf(vararg dependencies: Observable, valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create an [StringBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toStringBinding(noinline valueProvider: (V?) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toStringBinding(noinline valueProvider: (Boolean) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toStringBinding(noinline valueProvider: (Double) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Double) }

/** Create an [StringBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toStringBinding(noinline valueProvider: (Float) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Float) }

/** Create an [StringBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toStringBinding(noinline valueProvider: (Int) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Int) }

/** Create an [StringBinding] with single observable long dependency. */
inline fun ObservableLongValue.toStringBinding(noinline valueProvider: (Long) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Long) }

/** Create an [StringBinding] with single observable list dependency. */
inline fun <E> ObservableList<E>.toStringBinding(noinline valueProvider: (List<E>) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(this) }

/** Create an [StringBinding] with single observable set dependency. */
inline fun <E> ObservableSet<E>.toStringBinding(noinline valueProvider: (Set<E>) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(this) }

/** Create an [StringBinding] with single observable map dependency. */
inline fun <K, V> ObservableMap<K, V>.toStringBinding(noinline valueProvider: (Map<K, V>) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(this) }
