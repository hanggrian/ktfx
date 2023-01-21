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
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet
import ktfx.collections.observableListOf
import ktfx.collections.toObservableList
import java.util.concurrent.Callable

/** Create an [ObjectBinding] with multiple [Observable] dependencies. */
inline fun <T> bindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> T?
): ObjectBinding<T> = Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create a [ObjectBinding] with multiple [Observable] dependencies using collection. */
fun <T> bindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> T?
): ObjectBinding<T> = bindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [ObjectBinding] with single [ObservableList] dependency. */
fun <E, T> ObservableList<E>.asAny(valueProvider: (List<E>) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny)
        override fun getDependencies(): ObservableList<*> = this@asAny

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableSet] dependency. */
fun <E, T> ObservableSet<E>.asAny(valueProvider: (Set<E>) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny)
        override fun getDependencies(): ObservableList<*> = this@asAny.toObservableList()

        init {
            bind(this@asAny)
        }
    }

/** Create an [ObjectBinding] with single [ObservableMap] dependency. */
fun <K, V, T> ObservableMap<K, V>.asAny(valueProvider: (Map<K, V>) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        override fun dispose(): Unit = unbind(this@asAny)
        override fun computeValue(): T? = valueProvider(this@asAny)
        override fun getDependencies(): ObservableList<*> = this@asAny.keys.toObservableList()

        init {
            bind(this@asAny)
        }
    }

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
