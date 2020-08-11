@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

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
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create an [IntegerBinding] with multiple [Observable] dependencies. */
inline fun intBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Int): IntegerBinding =
    Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create an [IntegerBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.toIntBinding(valueProvider: (V?) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.toIntBinding(valueProvider: (Boolean) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.toIntBinding(valueProvider: (Double) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.toIntBinding(valueProvider: (Float) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.toIntBinding(valueProvider: (Int) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.toIntBinding(valueProvider: (Long) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@toIntBinding)
        override fun computeValue(): Int = valueProvider(this@toIntBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toIntBinding)

        init {
            bind(this@toIntBinding)
        }
    }
