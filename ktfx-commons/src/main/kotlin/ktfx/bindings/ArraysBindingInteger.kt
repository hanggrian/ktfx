@file:JvmMultifileClass
@file:JvmName("ArraysBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableIntegerArray

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the
 * specified position.
 */
inline fun ObservableIntegerArray.getBinding(index: Int): IntegerBinding =
    Bindings.integerValueAt(this, index)

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the
 * specified position.
 */
inline fun ObservableIntegerArray.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableIntegerArray] at the
 * specified position.
 */
inline fun ObservableIntegerArray.getBinding(index: ObservableIntegerValue): IntegerBinding =
    Bindings.integerValueAt(this, index)
