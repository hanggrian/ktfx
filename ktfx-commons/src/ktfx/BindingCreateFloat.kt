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

/** Create an [FloatBinding] with multiple observable [dependencies]. */
fun floatBindingOf(vararg dependencies: Observable, valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create an [FloatBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toFloat(noinline valueProvider: (V?) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toFloat(noinline valueProvider: (Boolean) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value) }

/** Create an [FloatBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toFloat(noinline valueProvider: (Double) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Double) }

/** Create an [FloatBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toFloat(noinline valueProvider: (Float) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Float) }

/** Create an [FloatBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toFloat(noinline valueProvider: (Int) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Int) }

/** Create an [FloatBinding] with single observable long dependency. */
inline fun ObservableLongValue.toFloat(noinline valueProvider: (Long) -> Float): FloatBinding =
    floatBindingOf(this) { valueProvider(value as Long) }
