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

/** Create an [LongBinding] with multiple observable [dependencies]. */
fun longBindingOf(vararg dependencies: Observable, valueProvider: () -> Long): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create an [LongBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toLong(noinline valueProvider: (V?) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create an [LongBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toLong(noinline valueProvider: (Boolean) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create an [LongBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toLong(noinline valueProvider: (Double) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Double) }

/** Create an [LongBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toLong(noinline valueProvider: (Float) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Float) }

/** Create an [LongBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toLong(noinline valueProvider: (Int) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Int) }

/** Create an [LongBinding] with single observable long dependency. */
inline fun ObservableLongValue.toLong(noinline valueProvider: (Long) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Long) }
