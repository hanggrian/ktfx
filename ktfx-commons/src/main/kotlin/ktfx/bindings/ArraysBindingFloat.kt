@file:JvmMultifileClass
@file:JvmName("ArraysBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.ObservableFloatArray

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the
 * specified position.
 */
inline fun ObservableFloatArray.getBinding(index: Int): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the
 * specified position.
 */
inline fun ObservableFloatArray.getBinding(index: ObservableNumberValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the
 * specified position.
 */
inline fun ObservableFloatArray.getBinding(index: ObservableIntegerValue): FloatBinding =
    Bindings.floatValueAt(this, index)
