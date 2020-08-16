@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create a [DoubleBinding] with multiple [Observable] dependencies. */
inline fun doubleBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Double): DoubleBinding =
    Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create a [DoubleBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.asDouble(valueProvider: (V?) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }

/** Create a [DoubleBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.asDouble(valueProvider: (Boolean) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }

/** Create a [DoubleBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.asDouble(valueProvider: (Double) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }

/** Create a [DoubleBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.asDouble(valueProvider: (Float) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }

/** Create a [DoubleBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.asDouble(valueProvider: (Int) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }

/** Create a [DoubleBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.asDouble(valueProvider: (Long) -> Double): DoubleBinding =
    object : DoubleBinding() {
        override fun dispose(): Unit = unbind(this@asDouble)
        override fun computeValue(): Double = valueProvider(this@asDouble.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asDouble)

        init {
            bind(this@asDouble)
        }
    }
