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
public inline fun <T> bindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> T?,
): ObjectBinding<T> = Bindings.createObjectBinding<T>(Callable(valueProvider), *dependencies)

/** Create a [ObjectBinding] with multiple [Observable] dependencies using collection. */
public fun <T> bindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> T?,
): ObjectBinding<T> = bindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [ObjectBinding] with single [ObservableList] dependency. */
public fun <E, T> ObservableList<E>.bindingBy(valueProvider: (List<E>) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy)

        override fun getDependencies(): ObservableList<*> = this@bindingBy
    }

/** Create an [ObjectBinding] with single [ObservableSet] dependency. */
public fun <E, T> ObservableSet<E>.bindingBy(valueProvider: (Set<E>) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy)

        override fun getDependencies(): ObservableList<*> = this@bindingBy.toObservableList()
    }

/** Create an [ObjectBinding] with single [ObservableMap] dependency. */
public fun <K, V, T> ObservableMap<K, V>.bindingBy(
    valueProvider: (Map<K, V>) -> T?,
): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy)

        override fun getDependencies(): ObservableList<*> = this@bindingBy.keys.toObservableList()
    }

/** Create an [ObjectBinding] with single [ObservableObjectValue] dependency. */
public fun <V, T> ObservableObjectValue<V>.bindingBy(valueProvider: (V?) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }

/** Create an [ObjectBinding] with single [ObservableBooleanValue] dependency. */
public fun <T> ObservableBooleanValue.bindingBy(valueProvider: (Boolean) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }

/** Create an [ObjectBinding] with single [ObservableDoubleValue] dependency. */
public fun <T> ObservableDoubleValue.bindingBy(valueProvider: (Double) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }

/** Create an [ObjectBinding] with single [ObservableFloatValue] dependency. */
public fun <T> ObservableFloatValue.bindingBy(valueProvider: (Float) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }

/** Create an [ObjectBinding] with single [ObservableIntegerValue] dependency. */
public fun <T> ObservableIntegerValue.bindingBy(valueProvider: (Int) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }

/** Create an [ObjectBinding] with single [ObservableLongValue] dependency. */
public fun <T> ObservableLongValue.bindingBy(valueProvider: (Long) -> T?): ObjectBinding<T> =
    object : ObjectBinding<T>() {
        init {
            bind(this@bindingBy)
        }

        override fun dispose(): Unit = unbind(this@bindingBy)

        override fun computeValue(): T? = valueProvider(this@bindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@bindingBy)
    }
