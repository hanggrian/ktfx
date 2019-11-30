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

/** Create an [FloatBinding] with multiple [Observable] dependencies. */
fun floatBindingOf(vararg dependencies: Observable, valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create an [FloatBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toFloatBinding(noinline valueProvider: (V?) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toFloatBinding(noinline valueProvider: (Boolean) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toFloatBinding(noinline valueProvider: (Double) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Double) }

/** Create an [FloatBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toFloatBinding(noinline valueProvider: (Float) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Float) }

/** Create an [FloatBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toFloatBinding(noinline valueProvider: (Int) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Int) }

/** Create an [FloatBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toFloatBinding(noinline valueProvider: (Long) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Long) }
