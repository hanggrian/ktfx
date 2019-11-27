@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

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

/** Create an [IntegerBinding] with multiple observable [dependencies]. */
fun intBindingOf(vararg dependencies: Observable, valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create an [IntegerBinding] with single observable dependency. */
inline fun <V> ObservableValue<V>.toInt(noinline valueProvider: (V?) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single observable boolean dependency. */
inline fun ObservableBooleanValue.toInt(noinline valueProvider: (Boolean) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value) }

/** Create an [IntegerBinding] with single observable double dependency. */
inline fun ObservableDoubleValue.toInt(noinline valueProvider: (Double) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Double) }

/** Create an [IntegerBinding] with single observable float dependency. */
inline fun ObservableFloatValue.toInt(noinline valueProvider: (Float) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Float) }

/** Create an [IntegerBinding] with single observable int dependency. */
inline fun ObservableIntegerValue.toInt(noinline valueProvider: (Int) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Int) }

/** Create an [IntegerBinding] with single observable long dependency. */
inline fun ObservableLongValue.toInt(noinline valueProvider: (Long) -> Int): IntegerBinding =
    intBindingOf(this) { valueProvider(value as Long) }
