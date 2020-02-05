@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableFloatArray

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
inline fun ObservableFloatArray.getBinding(index: Int): FloatBinding =
    Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
inline fun ObservableFloatArray.getBinding(index: ObservableNumberValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
inline fun ObservableFloatArray.getBinding(index: ObservableIntegerValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Performs the given [action] on each element binding.
 *
 * @see forEach
 */
inline fun ObservableFloatArray.forEachBinding(action: (FloatBinding) -> Unit) {
    for (index in 0 until size()) {
        action(Bindings.floatValueAt(this, index))
    }
}

/**
 * Performs the given [action] on each element binding, accompanied with the index of the element.
 *
 * @see forEachIndexed
 */
inline fun ObservableFloatArray.forEachBindingIndexed(action: (index: Int, FloatBinding) -> Unit) {
    for (index in 0 until size()) {
        action(index, Bindings.floatValueAt(this, index))
    }
}
