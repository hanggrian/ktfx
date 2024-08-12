@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
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

/** Create an [IntegerBinding] with multiple [Observable] dependencies. */
inline fun intBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> Int,
): IntegerBinding = Bindings.createIntegerBinding(Callable(valueProvider), *dependencies)

/** Create a [IntegerBinding] with multiple [Observable] dependencies using collection. */
fun intBindingOf(dependencies: Collection<Observable>, valueProvider: () -> Int): IntegerBinding =
    intBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [IntegerBinding] with single [ObservableList] dependency. */
fun <E> ObservableList<E>.intBindingBy(valueProvider: (List<E>) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy)

        override fun getDependencies(): ObservableList<*> = this@intBindingBy
    }

/** Create an [IntegerBinding] with single [ObservableSet] dependency. */
fun <E> ObservableSet<E>.intBindingBy(valueProvider: (Set<E>) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy)

        override fun getDependencies(): ObservableList<*> = this@intBindingBy.toObservableList()
    }

/** Create an [IntegerBinding] with single [ObservableMap] dependency. */
fun <K, V> ObservableMap<K, V>.intBindingBy(valueProvider: (Map<K, V>) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@intBindingBy.keys.toObservableList()
    }

/** Create an [IntegerBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.intBindingBy(valueProvider: (V?) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }

/** Create an [IntegerBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.intBindingBy(valueProvider: (Boolean) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }

/** Create an [IntegerBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.intBindingBy(valueProvider: (Double) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }

/** Create an [IntegerBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.intBindingBy(valueProvider: (Float) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }

/** Create an [IntegerBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.intBindingBy(valueProvider: (Int) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }

/** Create an [IntegerBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.intBindingBy(valueProvider: (Long) -> Int): IntegerBinding =
    object : IntegerBinding() {
        init {
            bind(this@intBindingBy)
        }

        override fun dispose(): Unit = unbind(this@intBindingBy)

        override fun computeValue(): Int = valueProvider(this@intBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@intBindingBy)
    }
