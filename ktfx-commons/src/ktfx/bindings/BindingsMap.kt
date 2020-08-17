@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.MapBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableObjectValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import ktfx.collections.observableListOf
import ktfx.collections.toObservableList

/** Create a [MapBinding] with multiple [Observable] dependencies. */
fun <K, V> mapBindingOf(vararg dependencies: Observable, valueProvider: () -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(*dependencies)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider()
        override fun getDependencies(): ObservableList<*> = dependencies.toObservableList()

        init {
            bind(*dependencies)
        }
    }

/** Create an [MapBinding] with single [ObservableObjectValue] dependency. */
fun <V2, K, V> ObservableObjectValue<V2>.asMap(valueProvider: (V2?) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }

/** Create an [MapBinding] with single [ObservableBooleanValue] dependency. */
fun <K, V> ObservableBooleanValue.asMap(valueProvider: (Boolean) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }

/** Create an [MapBinding] with single [ObservableDoubleValue] dependency. */
fun <K, V> ObservableDoubleValue.asMap(valueProvider: (Double) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }

/** Create an [MapBinding] with single [ObservableFloatValue] dependency. */
fun <K, V> ObservableFloatValue.asMap(valueProvider: (Float) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }

/** Create an [MapBinding] with single [ObservableIntegerValue] dependency. */
fun <K, V> ObservableIntegerValue.asMap(valueProvider: (Int) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }

/** Create an [MapBinding] with single [ObservableLongValue] dependency. */
fun <K, V> ObservableLongValue.asMap(valueProvider: (Long) -> ObservableMap<K, V>?): MapBinding<K, V> =
    object : MapBinding<K, V>() {
        override fun dispose(): Unit = unbind(this@asMap)
        override fun computeValue(): ObservableMap<K, V>? = valueProvider(this@asMap.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asMap)

        init {
            bind(this@asMap)
        }
    }
