@file:JvmMultifileClass
@file:JvmName("FXCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.collections

import javafx.collections.FXCollections.observableFloatArray
import javafx.collections.FXCollections.observableIntegerArray
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/** Returns an empty observable integer array. */
inline fun observableIntArrayOf(): ObservableIntegerArray = observableIntegerArray()

/** Returns an observable integer array of [elements]. */
inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = observableIntegerArray(*elements)

/** Converts this integer array to observable integer array. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(*this)

/** Creates a copy of this observable integer array. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = observableIntegerArray(this)

/** Returns an empty observable float array. */
inline fun observableFloatArrayOf(): ObservableFloatArray = observableFloatArray()

/** Returns an observable float array of [elements]. */
inline fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray = observableFloatArray(*elements)

/** Converts this float array to observable float array. */
inline fun FloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(*this)

/** Creates a copy of this observable float array. */
inline fun ObservableFloatArray.toObservableArray(): ObservableFloatArray = observableFloatArray(this)