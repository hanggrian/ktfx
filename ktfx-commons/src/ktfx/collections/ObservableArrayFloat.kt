@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.FloatBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.FXCollections
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/**
 * Returns an empty [ObservableFloatArray].
 *
 * @see floatArrayOf
 */
fun observableFloatArrayOf(): ObservableFloatArray =
    FXCollections.observableFloatArray()

/**
 * Returns an [ObservableFloatArray] of [elements].
 *
 * @see floatArrayOf
 */
fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray =
    if (elements.isNotEmpty()) elements.toObservableArray() else observableFloatArrayOf()

/** Converts this array of float to [ObservableFloatArray]. */
fun FloatArray.toObservableArray(): ObservableFloatArray =
    FXCollections.observableFloatArray(*this)

/** Converts this typed array of float to [ObservableIntegerArray]. */
inline fun Array<Float>.toObservableArray(): ObservableFloatArray =
    toFloatArray().toObservableArray()

/** Creates a copy of this [ObservableFloatArray]. */
fun ObservableFloatArray.toObservableArray(): ObservableFloatArray =
    FXCollections.observableFloatArray(this)

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
fun ObservableFloatArray.getBinding(index: Int): FloatBinding =
    Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
fun ObservableFloatArray.getBinding(index: ObservableNumberValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableFloatArray] at the specified position. */
inline fun ObservableFloatArray.getBinding(index: ObservableIntegerValue): FloatBinding =
    getBinding(index as ObservableNumberValue)

operator fun ObservableFloatArray.contains(value: Float): Boolean =
    (0 until size).any { get(it) == value }

inline operator fun ObservableFloatArray.plusAssign(value: Float): Unit =
    addAll(value)

inline operator fun ObservableFloatArray.plusAssign(array: FloatArray): Unit =
    addAll(*array)

inline operator fun ObservableFloatArray.plusAssign(array: ObservableFloatArray): Unit =
    addAll(array)

inline fun ObservableFloatArray.forEach(action: (value: Float) -> Unit) {
    for (index in 0 until size) {
        action(get(index))
    }
}

inline fun ObservableFloatArray.forEachIndexed(action: (index: Int, value: Float) -> Unit) {
    for (index in 0 until size) {
        action(index, get(index))
    }
}

inline fun ObservableFloatArray.forEachBinding(action: (value: FloatBinding) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

inline fun ObservableFloatArray.forEachBindingIndexed(action: (index: Int, value: FloatBinding) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
