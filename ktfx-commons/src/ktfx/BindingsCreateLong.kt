@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.LongBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create a [LongBinding] with multiple [Observable] dependencies. */
inline fun longBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Long): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create a [LongBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toLongBinding(noinline valueProvider: (V?) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value) }, this)

/** Create a [LongBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toLongBinding(noinline valueProvider: (Boolean) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value) }, this)

/** Create a [LongBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toLongBinding(noinline valueProvider: (Double) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [LongBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toLongBinding(noinline valueProvider: (Float) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [LongBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toLongBinding(noinline valueProvider: (Int) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [LongBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toLongBinding(noinline valueProvider: (Long) -> Long): LongBinding =
    Bindings.createLongBinding(Callable { valueProvider(value as Long) }, this)
