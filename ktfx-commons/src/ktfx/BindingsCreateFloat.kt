@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

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
import ktfx.collections.observableListOf
import java.util.concurrent.Callable

/** Create a [FloatBinding] with multiple [Observable] dependencies. */
inline fun floatBindingOf(vararg dependencies: Observable, noinline valueProvider: () -> Float): FloatBinding =
    Bindings.createFloatBinding(Callable(valueProvider), *dependencies)

/** Create a [FloatBinding] with single [ObservableObjectValue] dependency. */
fun <V> ObservableObjectValue<V>.toFloatBinding(valueProvider: (V?) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }

/** Create a [FloatBinding] with single [ObservableBooleanValue] dependency. */
fun ObservableBooleanValue.toFloatBinding(valueProvider: (Boolean) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }

/** Create a [FloatBinding] with single [ObservableDoubleValue] dependency. */
fun ObservableDoubleValue.toFloatBinding(valueProvider: (Double) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value as Double)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }

/** Create a [FloatBinding] with single [ObservableFloatValue] dependency. */
fun ObservableFloatValue.toFloatBinding(valueProvider: (Float) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value as Float)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }

/** Create a [FloatBinding] with single [ObservableIntegerValue] dependency. */
fun ObservableIntegerValue.toFloatBinding(valueProvider: (Int) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value as Int)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }

/** Create a [FloatBinding] with single [ObservableLongValue] dependency. */
fun ObservableLongValue.toFloatBinding(valueProvider: (Long) -> Float): FloatBinding =
    object : FloatBinding() {
        override fun dispose(): Unit = unbind(this@toFloatBinding)
        override fun computeValue(): Float = valueProvider(this@toFloatBinding.value as Long)
        override fun getDependencies(): ObservableList<*> = observableListOf(this@toFloatBinding)

        init {
            bind(this@toFloatBinding)
        }
    }
