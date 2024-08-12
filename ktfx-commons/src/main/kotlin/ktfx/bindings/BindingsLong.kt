@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.LongBinding
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

/** Create a [LongBinding] with multiple [Observable] dependencies. */
inline fun longBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> Long,
): LongBinding = Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create a [LongBinding] with multiple [Observable] dependencies using collection. */
fun longBindingOf(dependencies: Collection<Observable>, valueProvider: () -> Long): LongBinding =
    longBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [LongBinding] with single [ObservableList] dependency. */
fun <E> ObservableList<E>.longBindingBy(valueProvider: (List<E>) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy)

        override fun getDependencies(): ObservableList<*> = this@longBindingBy
    }

/** Create an [LongBinding] with single [ObservableSet] dependency. */
fun <E> ObservableSet<E>.longBindingBy(valueProvider: (Set<E>) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy)

        override fun getDependencies(): ObservableList<*> = this@longBindingBy.toObservableList()
    }

/** Create an [LongBinding] with single [ObservableMap] dependency. */
fun <K, V> ObservableMap<K, V>.longBindingBy(valueProvider: (Map<K, V>) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@longBindingBy.keys.toObservableList()
    }

/** Create a [LongBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.longBindingBy(valueProvider: (V?) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }

/** Create a [LongBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.longBindingBy(valueProvider: (Boolean) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }

/** Create a [LongBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.longBindingBy(valueProvider: (Double) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }

/** Create a [LongBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.longBindingBy(valueProvider: (Float) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }

/** Create a [LongBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.longBindingBy(valueProvider: (Int) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }

/** Create a [LongBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.longBindingBy(valueProvider: (Long) -> Long): LongBinding =
    object : LongBinding() {
        init {
            bind(this@longBindingBy)
        }

        override fun dispose(): Unit = unbind(this@longBindingBy)

        override fun computeValue(): Long = valueProvider(this@longBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@longBindingBy)
    }
