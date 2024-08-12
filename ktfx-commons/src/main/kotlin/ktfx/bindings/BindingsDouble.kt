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
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet
import ktfx.collections.observableListOf
import ktfx.collections.toObservableList
import java.util.concurrent.Callable

/** Create a [DoubleBinding] with multiple [Observable] dependencies. */
inline fun doubleBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> Double,
): DoubleBinding = Bindings.createDoubleBinding(Callable(valueProvider), *dependencies)

/** Create a [DoubleBinding] with multiple [Observable] dependencies using collection. */
fun doubleBindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> Double,
): DoubleBinding = doubleBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [DoubleBinding] with single [ObservableList] dependency. */
fun <E> ObservableList<E>.doubleBindingBy(valueProvider: (List<E>) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy)

        override fun getDependencies(): ObservableList<*> = this@doubleBindingBy
    }

/** Create an [DoubleBinding] with single [ObservableSet] dependency. */
fun <E> ObservableSet<E>.doubleBindingBy(valueProvider: (Set<E>) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy)

        override fun getDependencies(): ObservableList<*> = this@doubleBindingBy.toObservableList()
    }

/** Create an [DoubleBinding] with single [ObservableMap] dependency. */
fun <K, V> ObservableMap<K, V>.doubleBindingBy(
    valueProvider: (Map<K, V>) -> Double,
): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@doubleBindingBy.keys.toObservableList()
    }

/** Create a [DoubleBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.doubleBindingBy(valueProvider: (V?) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }

/** Create a [DoubleBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.doubleBindingBy(valueProvider: (Boolean) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }

/** Create a [DoubleBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.doubleBindingBy(valueProvider: (Double) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }

/** Create a [DoubleBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.doubleBindingBy(valueProvider: (Float) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }

/** Create a [DoubleBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.doubleBindingBy(valueProvider: (Int) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }

/** Create a [DoubleBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.doubleBindingBy(valueProvider: (Long) -> Double): DoubleBinding =
    object : DoubleBinding() {
        init {
            bind(this@doubleBindingBy)
        }

        override fun dispose(): Unit = unbind(this@doubleBindingBy)

        override fun computeValue(): Double = valueProvider(this@doubleBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@doubleBindingBy)
    }
