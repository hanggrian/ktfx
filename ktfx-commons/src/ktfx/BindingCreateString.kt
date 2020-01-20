@file:JvmMultifileClass
@file:JvmName("BindingKt")

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

/** Create a [StringBinding] with multiple [Observable] dependencies. */
inline fun stringBindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable { valueProvider() }, *dependencies)

/** Create a [StringBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toStringBinding(crossinline valueProvider: (V?) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create a [StringBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toStringBinding(crossinline valueProvider: (Boolean) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create a [StringBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toStringBinding(crossinline valueProvider: (Double) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Double) }

/** Create a [StringBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toStringBinding(crossinline valueProvider: (Float) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Float) }

/** Create a [StringBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toStringBinding(crossinline valueProvider: (Int) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Int) }

/** Create a [StringBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toStringBinding(crossinline valueProvider: (Long) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Long) }
