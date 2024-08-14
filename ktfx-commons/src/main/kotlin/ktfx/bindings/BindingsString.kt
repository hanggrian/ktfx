@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.StringBinding
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

/** Create a [StringBinding] with multiple [Observable] dependencies. */
public inline fun stringBindingOf(
    vararg dependencies: Observable,
    noinline valueProvider: () -> String?,
): StringBinding = Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create a [StringBinding] with multiple [Observable] dependencies using collection. */
public fun stringBindingOf(
    dependencies: Collection<Observable>,
    valueProvider: () -> String?,
): StringBinding = stringBindingOf(*dependencies.toTypedArray(), valueProvider = valueProvider)

/** Create an [StringBinding] with single [ObservableList] dependency. */
public fun <E> ObservableList<E>.stringBindingBy(
    valueProvider: (List<E>) -> String?,
): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy)

        override fun getDependencies(): ObservableList<*> = this@stringBindingBy
    }

/** Create an [StringBinding] with single [ObservableSet] dependency. */
public fun <E> ObservableSet<E>.stringBindingBy(valueProvider: (Set<E>) -> String?): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy)

        override fun getDependencies(): ObservableList<*> = this@stringBindingBy.toObservableList()
    }

/** Create an [StringBinding] with single [ObservableMap] dependency. */
public fun <K, V> ObservableMap<K, V>.stringBindingBy(
    valueProvider: (Map<K, V>) -> String?,
): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy)

        override fun getDependencies(): ObservableList<*> =
            this@stringBindingBy.keys.toObservableList()
    }

/** Create a [StringBinding] with single [ObservableObjectValue] dependency. */
public fun <V> ObservableObjectValue<V>.stringBindingBy(
    valueProvider: (V?) -> String?,
): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }

/** Create a [StringBinding] with single [ObservableBooleanValue] dependency. */
public fun ObservableBooleanValue.stringBindingBy(
    valueProvider: (Boolean) -> String?,
): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }

/** Create a [StringBinding] with single [ObservableDoubleValue] dependency. */
public fun ObservableDoubleValue.stringBindingBy(
    valueProvider: (Double) -> String?,
): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value as Double)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }

/** Create a [StringBinding] with single [ObservableFloatValue] dependency. */
public fun ObservableFloatValue.stringBindingBy(valueProvider: (Float) -> String?): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value as Float)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }

/** Create a [StringBinding] with single [ObservableIntegerValue] dependency. */
public fun ObservableIntegerValue.stringBindingBy(valueProvider: (Int) -> String?): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value as Int)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }

/** Create a [StringBinding] with single [ObservableLongValue] dependency. */
public fun ObservableLongValue.stringBindingBy(valueProvider: (Long) -> String?): StringBinding =
    object : StringBinding() {
        init {
            bind(this@stringBindingBy)
        }

        override fun dispose(): Unit = unbind(this@stringBindingBy)

        override fun computeValue(): String? = valueProvider(this@stringBindingBy.value as Long)

        override fun getDependencies(): ObservableList<*> = observableListOf(this@stringBindingBy)
    }
