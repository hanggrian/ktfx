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
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create a [StringBinding] with multiple [Observable] dependencies. */
inline fun stringBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> String?): StringBinding =
    Bindings.createStringBinding(Callable(valueProvider), *dependencies)

/** Create a [StringBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.toStringBinding(valueProvider: (V?) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }

/** Create a [StringBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.toStringBinding(valueProvider: (Boolean) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }

/** Create a [StringBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.toStringBinding(valueProvider: (Double) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }

/** Create a [StringBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.toStringBinding(valueProvider: (Float) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }

/** Create a [StringBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.toStringBinding(valueProvider: (Int) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }

/** Create a [StringBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.toStringBinding(valueProvider: (Long) -> String?): StringBinding =
    object : StringBinding() {
        override fun dispose(): Unit = unbind(this@toStringBinding)
        override fun computeValue(): String? = valueProvider(this@toStringBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toStringBinding)

        init {
            bind(this@toStringBinding)
        }
    }
