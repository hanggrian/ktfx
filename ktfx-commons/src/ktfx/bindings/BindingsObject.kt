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
fun <V, T> ObservableObjectValue<V>.asAny(valueProvider: (V?) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
fun <T> ObservableBooleanValue.asAny(valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
fun <T> ObservableDoubleValue.asAny(valueProvider: (Double) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
fun <T> ObservableFloatValue.asAny(valueProvider: (Float) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
fun <T> ObservableIntegerValue.asAny(valueProvider: (Int) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
fun <T> ObservableLongValue.asAny(valueProvider: (Long) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asAny)

        init {
            bind(this@asAny)
        }
    }
