@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableIntegerArray

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
inline fun ObservableIntegerArray.getBinding(index: Int): IntegerBinding =
    Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
inline fun ObservableIntegerArray.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the specified position. */
inline fun ObservableIntegerArray.getBinding(index: ObservableIntegerValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/** Performs the given [action] on each element binding. */
inline fun ObservableIntegerArray.forEachBinding(action: (IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

/** Performs the given [action] on each element binding, accompanied with the index of the element. */
inline fun ObservableIntegerArray.forEachBindingIndexed(action: (index: Int, IntegerBinding) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
