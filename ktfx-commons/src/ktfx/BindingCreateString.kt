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

/** Create an [StringBinding] with multiple observable [dependencies]. */
fun stringBindingOf(vararg dependencies: Observable, valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create an [StringBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toString(noinline valueProvider: (V?) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toString(noinline valueProvider: (Boolean) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value) }

/** Create an [StringBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toString(noinline valueProvider: (Double) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Double) }

/** Create an [StringBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toString(noinline valueProvider: (Float) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Float) }

/** Create an [StringBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toString(noinline valueProvider: (Int) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Int) }

/** Create an [StringBinding] with single observable long dependency. */
inline fun ObservableLongValue.toString(noinline valueProvider: (Long) -> String?): StringBinding =
    stringBindingOf(this) { valueProvider(value as Long) }
