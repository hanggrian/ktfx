@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create a [BooleanBinding] with multiple [Observable] dependencies. */
inline fun booleanBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Boolean): BooleanBinding =
    Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create a [BooleanBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.toBooleanBinding(valueProvider: (V?) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }

/** Create a [BooleanBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.toBooleanBinding(valueProvider: (Boolean) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }

/** Create a [BooleanBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.toBooleanBinding(valueProvider: (Double) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }

/** Create a [BooleanBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.toBooleanBinding(valueProvider: (Float) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }

/** Create a [BooleanBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.toBooleanBinding(valueProvider: (Int) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }

/** Create a [BooleanBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.toBooleanBinding(valueProvider: (Long) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        override fun dispose(): Unit = unbind(this@toBooleanBinding)
        override fun computeValue(): Boolean = valueProvider(this@toBooleanBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBooleanBinding)

        init {
            bind(this@toBooleanBinding)
        }
    }
