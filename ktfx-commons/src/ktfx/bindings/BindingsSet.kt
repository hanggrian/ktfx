@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.SetBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import javafx.collections.ObservableSet
import ktfx.collections.observableListOf
import ktfx.collections.toObservableList

/** Create a [SetBinding] with multiple [Observable] dependencies. */
fun <E> setBindingOf(vararg dependencies: Observable, valueProvider: () -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(*dependencies)
        override fun computeValue(): ObservableSet<E>? = valueProvider()
        override fun getDependencies(): ObservableList<*> = dependencies.toObservableList()

        init {
            bind(*dependencies)
        }
    }

/** Create an [SetBinding] with single [ObservableObjectValue] dependency. */
fun <V, E> ObservableObjectValue<V>.asSet(valueProvider: (V?) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }

/** Create an [SetBinding] with single [ObservableBooleanValue] dependency. */
fun <E> ObservableBooleanValue.asSet(valueProvider: (Boolean) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }

/** Create an [SetBinding] with single [ObservableDoubleValue] dependency. */
fun <E> ObservableDoubleValue.asSet(valueProvider: (Double) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }

/** Create an [SetBinding] with single [ObservableFloatValue] dependency. */
fun <E> ObservableFloatValue.asSet(valueProvider: (Float) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }

/** Create an [SetBinding] with single [ObservableIntegerValue] dependency. */
fun <E> ObservableIntegerValue.asSet(valueProvider: (Int) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }

/** Create an [SetBinding] with single [ObservableLongValue] dependency. */
fun <E> ObservableLongValue.asSet(valueProvider: (Long) -> ObservableSet<E>?): SetBinding<E> =
    object : SetBinding<E>() {
        override fun dispose(): Unit = unbind(this@asSet)
        override fun computeValue(): ObservableSet<E>? = valueProvider(this@asSet.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asSet)

        init {
            bind(this@asSet)
        }
    }
