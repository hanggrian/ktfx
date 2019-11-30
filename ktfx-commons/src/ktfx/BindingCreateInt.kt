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

/** Create an [IntegerBinding] with multiple [Observable] dependencies. */
fun intBindingOf(vararg dependencies: Observable, valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create an [IntegerBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toIntBinding(noinline valueProvider: (V?) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toIntBinding(noinline valueProvider: (Boolean) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toIntBinding(noinline valueProvider: (Double) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Double) }

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toIntBinding(noinline valueProvider: (Float) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Float) }

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toIntBinding(noinline valueProvider: (Int) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Int) }

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toIntBinding(noinline valueProvider: (Long) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Long) }
