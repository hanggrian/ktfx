@file:JvmMultifileClass
@file:JvmName("BindingKt")

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

/** Create a [FloatBinding] with multiple [Observable] dependencies. */
inline fun floatBindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider() }, *dependencies)

/** Create a [FloatBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toFloatBinding(crossinline valueProvider: (V?) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create a [FloatBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toFloatBinding(crossinline valueProvider: (Boolean) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create a [FloatBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toFloatBinding(crossinline valueProvider: (Double) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Double) }

/** Create a [FloatBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toFloatBinding(crossinline valueProvider: (Float) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Float) }

/** Create a [FloatBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toFloatBinding(crossinline valueProvider: (Int) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Int) }

/** Create a [FloatBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toFloatBinding(crossinline valueProvider: (Long) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Long) }
