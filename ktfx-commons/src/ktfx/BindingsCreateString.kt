@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create a [StringBinding] with multiple [Observable] dependencies. */
inline fun stringBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create a [StringBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toStringBinding(noinline valueProvider: (V?) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value) }, this)

/** Create a [StringBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toStringBinding(noinline valueProvider: (Boolean) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value) }, this)

/** Create a [StringBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toStringBinding(noinline valueProvider: (Double) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value as Double) }, this)

/** Create a [StringBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toStringBinding(noinline valueProvider: (Float) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value as Float) }, this)

/** Create a [StringBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toStringBinding(noinline valueProvider: (Int) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value as Int) }, this)

/** Create a [StringBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toStringBinding(noinline valueProvider: (Long) -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider(value as Long) }, this)
