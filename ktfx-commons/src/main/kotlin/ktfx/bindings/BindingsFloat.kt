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
public inline fun floatBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> Float,
): FloatBinding = Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create a [FloatBinding] with multiple [Observable] dependencies using collection. */
public fun floatBindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> Float,
): FloatBinding = floatBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [FloatBinding] with single [ObservableList] dependency. */
public fun <E> ObservableList<E>.floatBindingBy(valueProvider: (List<E>) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy)

        override fun getDependencies(): ObservableList<*> = this@floatBindingBy
    }

/** Create an [FloatBinding] with single [ObservableSet] dependency. */
public fun <E> ObservableSet<E>.floatBindingBy(valueProvider: (Set<E>) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy)

        override fun getDependencies(): ObservableList<*> = this@floatBindingBy.toObservableList()
    }

/** Create an [FloatBinding] with single [ObservableMap] dependency. */
public fun <K, V> ObservableMap<K, V>.floatBindingBy(
    valueProvider: (Map<K, V>) -> Float,
): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@floatBindingBy.keys.toObservableList()
    }

/** Create a [FloatBinding] with single [ObservableObjectValue] dependency. */
public fun <V> ObservableObjectValue<V>.floatBindingBy(valueProvider: (V?) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }

/** Create a [FloatBinding] with single [ObservableBooleanValue] dependency. */
public fun ObservableBooleanValue.floatBindingBy(valueProvider: (Boolean) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }

/** Create a [FloatBinding] with single [ObservableDoubleValue] dependency. */
public fun ObservableDoubleValue.floatBindingBy(valueProvider: (Double) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }

/** Create a [FloatBinding] with single [ObservableFloatValue] dependency. */
public fun ObservableFloatValue.floatBindingBy(valueProvider: (Float) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }

/** Create a [FloatBinding] with single [ObservableIntegerValue] dependency. */
public fun ObservableIntegerValue.floatBindingBy(valueProvider: (Int) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }

/** Create a [FloatBinding] with single [ObservableLongValue] dependency. */
public fun ObservableLongValue.floatBindingBy(valueProvider: (Long) -> Float): FloatBinding =
    object : FloatBinding() {
        init {
            bind(this@floatBindingBy)
        }

        override fun dispose(): Unit = unbind(this@floatBindingBy)

        override fun computeValue(): Float = valueProvider(this@floatBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@floatBindingBy)
    }
