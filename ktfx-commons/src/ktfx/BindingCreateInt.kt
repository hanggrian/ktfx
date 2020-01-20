@file:JvmMultifileClass
@file:JvmName("BindingKt")

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
inline fun intBindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider() }, *dependencies)

/** Create an [IntegerBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toIntBinding(crossinline valueProvider: (V?) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toIntBinding(crossinline valueProvider: (Boolean) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toIntBinding(crossinline valueProvider: (Double) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Double) }

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toIntBinding(crossinline valueProvider: (Float) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Float) }

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toIntBinding(crossinline valueProvider: (Int) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Int) }

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toIntBinding(crossinline valueProvider: (Long) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Long) }
