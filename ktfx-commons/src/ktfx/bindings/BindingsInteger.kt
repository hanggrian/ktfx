@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

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
fun <V> ObservableObjectValue<V>.asInt(valueProvider: (V?) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.asInt(valueProvider: (Boolean) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.asInt(valueProvider: (Double) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.asInt(valueProvider: (Float) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.asInt(valueProvider: (Int) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.asInt(valueProvider: (Long) -> Int): IntegerBinding =
    object : IntegerBinding() {
        override fun dispose(): Unit = unbind(this@asInt)
        override fun computeValue(): Int = valueProvider(this@asInt.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asInt)

        init {
            bind(this@asInt)
        }
    }
