@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue

/** Create an [StringBinding] with multiple [Observable] dependencies. */
fun stringBindingOf(vararg dependencies: Observable, valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create an [StringBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toStringBinding(noinline valueProvider: (V?) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toStringBinding(noinline valueProvider: (Boolean) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toStringBinding(noinline valueProvider: (Double) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Double) }

/** Create an [StringBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toStringBinding(noinline valueProvider: (Float) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Float) }

/** Create an [StringBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toStringBinding(noinline valueProvider: (Int) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Int) }

/** Create an [StringBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toStringBinding(noinline valueProvider: (Long) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Long) }
