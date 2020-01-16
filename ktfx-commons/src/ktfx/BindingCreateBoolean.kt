@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue

/** Create a [BooleanBinding] with multiple [Observable] dependencies. */
fun booleanBindingOf(vararg dependencies: Observable, valueProvider: () -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create a [BooleanBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toBooleanBinding(noinline valueProvider: (V?) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value) }

/** Create a [BooleanBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toBooleanBinding(noinline valueProvider: (Boolean) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value) }

/** Create a [BooleanBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toBooleanBinding(noinline valueProvider: (Double) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Double) }

/** Create a [BooleanBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toBooleanBinding(noinline valueProvider: (Float) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Float) }

/** Create a [BooleanBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toBooleanBinding(noinline valueProvider: (Int) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Int) }

/** Create a [BooleanBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toBooleanBinding(noinline valueProvider: (Long) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Long) }
