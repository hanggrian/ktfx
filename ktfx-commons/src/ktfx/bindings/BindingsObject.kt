@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.ObjectBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create an [ObjectBinding] with multiple [Observable] dependencies. */
inline fun <T> bindingOf(vararg dependencies: Observable, noinline valueProvider: () -> T?): ObjectBinding<T> =
    Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create an [ObjectBinding] with single [ObservableObjectValue] dependency. */
fun <V, T> ObservableObjectValue<V>.toBinding(valueProvider: (V?) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
fun <T> ObservableBooleanValue.toBinding(valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
fun <T> ObservableDoubleValue.toBinding(valueProvider: (Double) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
fun <T> ObservableFloatValue.toBinding(valueProvider: (Float) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
fun <T> ObservableIntegerValue.toBinding(valueProvider: (Int) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
fun <T> ObservableLongValue.toBinding(valueProvider: (Long) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@toBinding)
        override fun computeValue(): T? = valueProvider(this@toBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toBinding)

        init {
            bind(this@toBinding)
        }
    }
