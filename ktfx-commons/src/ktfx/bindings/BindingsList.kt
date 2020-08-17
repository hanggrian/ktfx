@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.ListBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import ktfx.collections.observableListOf
import ktfx.collections.toObservableList

/** Create a [ListBinding] with multiple [Observable] dependencies. */
fun <E> listBindingOf(vararg dependencies: Observable, valueProvider: () -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(*dependencies)
        override fun computeValue(): ObservableList<E>? = valueProvider()
        override fun getDependencies(): ObservableList<*> = dependencies.toObservableList()

        init {
            bind(*dependencies)
        }
    }

/** Create an [ListBinding] with single [ObservableObjectValue] dependency. */
fun <V, E> ObservableObjectValue<V>.asList(valueProvider: (V?) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }

/** Create an [ListBinding] with single [ObservableBooleanValue] dependency. */
fun <E> ObservableBooleanValue.asList(valueProvider: (Boolean) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }

/** Create an [ListBinding] with single [ObservableDoubleValue] dependency. */
fun <E> ObservableDoubleValue.asList(valueProvider: (Double) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }

/** Create an [ListBinding] with single [ObservableFloatValue] dependency. */
fun <E> ObservableFloatValue.asList(valueProvider: (Float) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }

/** Create an [ListBinding] with single [ObservableIntegerValue] dependency. */
fun <E> ObservableIntegerValue.asList(valueProvider: (Int) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }

/** Create an [ListBinding] with single [ObservableLongValue] dependency. */
fun <E> ObservableLongValue.asList(valueProvider: (Long) -> ObservableList<E>?): ListBinding<E> =
    object : ListBinding<E>() {
        override fun dispose(): Unit = unbind(this@asList)
        override fun computeValue(): ObservableList<E>? = valueProvider(this@asList.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asList)

        init {
            bind(this@asList)
        }
    }
