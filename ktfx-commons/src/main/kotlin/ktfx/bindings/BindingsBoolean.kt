@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
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

/** Create a [BooleanBinding] with multiple [Observable] dependencies. */
public inline fun booleanBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> Boolean,
): BooleanBinding = Bindings.createBooleanBinding(Callable(valueProvider), *dependencies)

/** Create a [BooleanBinding] with multiple [Observable] dependencies using collection. */
public fun booleanBindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> Boolean,
): BooleanBinding = booleanBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [BooleanBinding] with single [ObservableList] dependency. */
public fun <E> ObservableList<E>.booleanBindingBy(
    valueProvider: (List<E>) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy)

        override fun getDependencies(): ObservableList<*> = this@booleanBindingBy
    }

/** Create an [BooleanBinding] with single [ObservableSet] dependency. */
public fun <E> ObservableSet<E>.booleanBindingBy(
    valueProvider: (Set<E>) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy)

        override fun getDependencies(): ObservableList<*> = this@booleanBindingBy.toObservableList()
    }

/** Create an [BooleanBinding] with single [ObservableMap] dependency. */
public fun <K, V> ObservableMap<K, V>.booleanBindingBy(
    valueProvider: (Map<K, V>) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@booleanBindingBy.keys.toObservableList()
    }

/** Create a [BooleanBinding] with single [ObservableObjectValue] dependency. */
public fun <V> ObservableObjectValue<V>.booleanBindingBy(
    valueProvider: (V?) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }

/** Create a [BooleanBinding] with single [ObservableBooleanValue] dependency. */
public fun ObservableBooleanValue.booleanBindingBy(
    valueProvider: (Boolean) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }

/** Create a [BooleanBinding] with single [ObservableDoubleValue] dependency. */
public fun ObservableDoubleValue.booleanBindingBy(
    valueProvider: (Double) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }

/** Create a [BooleanBinding] with single [ObservableFloatValue] dependency. */
public fun ObservableFloatValue.booleanBindingBy(
    valueProvider: (Float) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }

/** Create a [BooleanBinding] with single [ObservableIntegerValue] dependency. */
public fun ObservableIntegerValue.booleanBindingBy(
    valueProvider: (Int) -> Boolean,
): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }

/** Create a [BooleanBinding] with single [ObservableLongValue] dependency. */
public fun ObservableLongValue.booleanBindingBy(valueProvider: (Long) -> Boolean): BooleanBinding =
    object : BooleanBinding() {
        init {
            bind(this@booleanBindingBy)
        }

        override fun dispose(): Unit = unbind(this@booleanBindingBy)

        override fun computeValue(): Boolean = valueProvider(this@booleanBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@booleanBindingBy)
    }
