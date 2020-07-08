@file:JvmMultifileClass
@file:JvmName("BindingsKt")

package ktfx

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import java.util.concurrent.Callable

/** Create an [IntegerBinding] with multiple [Observable] dependencies. */
inline fun intBindingOf(vararg dependencies: Observable, crossinline valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider() }, *dependencies)

/** Create an [IntegerBinding] with single [ObservableObjectValue] dependency. */
inline fun <V> ObservableObjectValue<V>.toIntBinding(crossinline valueProvider: (V?) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value) }, this)

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toIntBinding(crossinline valueProvider: (Boolean) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value) }, this)

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toIntBinding(crossinline valueProvider: (Double) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value as Double) }, this)

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toIntBinding(crossinline valueProvider: (Float) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value as Float) }, this)

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toIntBinding(crossinline valueProvider: (Int) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value as Int) }, this)

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toIntBinding(crossinline valueProvider: (Long) -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable { valueProvider(value as Long) }, this)
