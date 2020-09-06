@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
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

/** Create a [FloatBinding] with multiple [Observable] dependencies. */
inline fun floatBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create a [FloatBinding] with multiple [Observable] dependencies using collection. */
fun floatBindingOf(dependencies: Collection<Observable>, valueProvider: () -> Float): FloatBinding =
    floatBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [FloatBinding] with single [ObservableList] dependency. */
fun <E> ObservableList<E>.asFloat(valueProvider: (List<E>) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat)
        override fun getDependencies(): ObservableList<*> = this@asFloat

        init {
            bind(this@asFloat)
        }
    }

/** Create an [FloatBinding] with single [ObservableSet] dependency. */
fun <E> ObservableSet<E>.asFloat(valueProvider: (Set<E>) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat)
        override fun getDependencies(): ObservableList<*> = this@asFloat.toObservableList()

        init {
            bind(this@asFloat)
        }
    }

/** Create an [FloatBinding] with single [ObservableMap] dependency. */
fun <K, V> ObservableMap<K, V>.asFloat(valueProvider: (Map<K, V>) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat)
        override fun getDependencies(): ObservableList<*> = this@asFloat.keys.toObservableList()

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.asFloat(valueProvider: (V?) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.asFloat(valueProvider: (Boolean) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.asFloat(valueProvider: (Double) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.asFloat(valueProvider: (Float) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.asFloat(valueProvider: (Int) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }

/** Create a [FloatBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.asFloat(valueProvider: (Long) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@asFloat)
        override fun computeValue(): Float = valueProvider(this@asFloat.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@asFloat)

        init {
            bind(this@asFloat)
        }
    }
