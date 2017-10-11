@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

/** Returns an empty observable integer array. */
inline fun observableIntArrayOf(): ObservableIntegerArray = FXCollections.observableIntegerArray()

/** Returns an observable integer array of [elements]. */
inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = FXCollections.observableIntegerArray(*elements)

/** Converts this integer array to observable integer array. */
inline fun IntArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*this)

/** Creates a copy of this observable integer array. */
inline fun ObservableIntegerArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(this)

/** Returns an empty observable float array. */
inline fun observableFloatArrayOf(): ObservableFloatArray = FXCollections.observableFloatArray()

/** Returns an observable float array of [elements]. */
inline fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray = FXCollections.observableFloatArray(*elements)

/** Converts this float array to observable float array. */
inline fun FloatArray.toObservableArray(): ObservableFloatArray = FXCollections.observableFloatArray(*this)

/** Creates a copy of this observable float array. */
inline fun ObservableFloatArray.toObservableArray(): ObservableFloatArray = FXCollections.observableFloatArray(this)