@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create an [FloatBinding] with multiple observable [dependencies]. */
fun floatBindingOf(vararg dependencies: Observable, valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create an [FloatBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toFloatBinding(noinline valueProvider: (V?) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toFloatBinding(noinline valueProvider: (Boolean) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toFloatBinding(noinline valueProvider: (Double) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Double) }

/** Create an [FloatBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toFloatBinding(noinline valueProvider: (Float) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Float) }

/** Create an [FloatBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toFloatBinding(noinline valueProvider: (Int) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Int) }

/** Create an [FloatBinding] with single observable long dependency. */
inline fun ObservableLongValue.toFloatBinding(noinline valueProvider: (Long) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Long) }

/** Create an [FloatBinding] with single observable list dependency. */
inline fun <E> ObservableList<E>.toFloatBinding(noinline valueProvider: (List<E>) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(this) }

/** Create an [FloatBinding] with single observable set dependency. */
inline fun <E> ObservableSet<E>.toFloatBinding(noinline valueProvider: (Set<E>) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(this) }

/** Create an [FloatBinding] with single observable map dependency. */
inline fun <K, V> ObservableMap<K, V>.toFloatBinding(noinline valueProvider: (Map<K, V>) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(this) }
