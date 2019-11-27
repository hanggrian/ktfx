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

/** Create an [BooleanBinding] with multiple observable [dependencies]. */
fun booleanBindingOf(vararg dependencies: Observable, valueProvider: () -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create an [BooleanBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toBoolean(noinline valueProvider: (V?) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value) }

/** Create an [BooleanBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toBoolean(noinline valueProvider: (Boolean) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value) }

/** Create an [BooleanBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toBoolean(noinline valueProvider: (Double) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Double) }

/** Create an [BooleanBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toBoolean(noinline valueProvider: (Float) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Float) }

/** Create an [BooleanBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toBoolean(noinline valueProvider: (Int) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Int) }

/** Create an [BooleanBinding] with single observable long dependency. */
inline fun ObservableLongValue.toBoolean(noinline valueProvider: (Long) -> Boolean): BooleanBinding =
    booleanBindingOf(this) { valueProvider(value as Long) }
