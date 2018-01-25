@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.FXCollections.observableFloatArray
import javafx.collections.FXCollections.observableIntegerArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/** Returns an empty [ObservableIntegerArray]. */
inline fun observableIntArrayOf(): ObservableIntegerArray = observableIntegerArray()

/** Returns an [ObservableIntegerArray] of [elements]. */
inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = observableIntegerArray(*elements)

/** Converts this [IntArray] to [ObservableIntegerArray]. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(*this)

/** Creates a copy of this [ObservableIntegerArray]. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(this)

/** Returns an empty [ObservableFloatArray]. */
inline fun observableFloatArrayOf(): ObservableFloatArray = observableFloatArray()

/** Returns an [ObservableFloatArray] of [elements]. */
inline fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray = observableFloatArray(*elements)

/** Converts this [FloatArray] to [ObservableFloatArray]. */
inline fun FloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(*this)

/** Creates a copy of this [ObservableFloatArray]. */
inline fun ObservableFloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(this)