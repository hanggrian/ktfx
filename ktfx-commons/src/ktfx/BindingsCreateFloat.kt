@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create a [FloatBinding] with multiple [Observable] dependencies. */
inline fun floatBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create a [FloatBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toFloatBinding(noinline valueProvider: (V?) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value) }, this)

/** Create a [FloatBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toFloatBinding(noinline valueProvider: (Boolean) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value) }, this)

/** Create a [FloatBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toFloatBinding(noinline valueProvider: (Double) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [FloatBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toFloatBinding(noinline valueProvider: (Float) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [FloatBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toFloatBinding(noinline valueProvider: (Int) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [FloatBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toFloatBinding(noinline valueProvider: (Long) -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable { valueProvider(value as Long) }, this)
