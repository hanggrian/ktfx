@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.LongBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create a [LongBinding] with multiple [Observable] dependencies. */
inline fun longBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Long): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create a [LongBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.toLongBinding(valueProvider: (V?) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }

/** Create a [LongBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.toLongBinding(valueProvider: (Boolean) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }

/** Create a [LongBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.toLongBinding(valueProvider: (Double) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }

/** Create a [LongBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.toLongBinding(valueProvider: (Float) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }

/** Create a [LongBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.toLongBinding(valueProvider: (Int) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }

/** Create a [LongBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.toLongBinding(valueProvider: (Long) -> Long): LongBinding =
    object : LongBinding() {
        override fun dispose(): Unit = unbind(this@toLongBinding)
        override fun computeValue(): Long = valueProvider(this@toLongBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toLongBinding)

        init {
            bind(this@toLongBinding)
        }
    }
