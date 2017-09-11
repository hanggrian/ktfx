@file:JvmMultifileClass
@file:JvmName("FXCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableFloatArray
import javafx.collections.ObservableIntegerArray

inline fun observableIntArrayOf(): ObservableIntegerArray = FXCollections.observableIntegerArray()

inline fun observableIntArrayOf(vararg elements: Int): ObservableIntegerArray = FXCollections.observableIntegerArray(*elements)

inline fun IntArray.toObservableArray(): ObservableIntegerArray = FXCollections.observableIntegerArray(*this)

inline fun observableFloatArrayOf(): ObservableFloatArray = FXCollections.observableFloatArray()

inline fun observableFloatArrayOf(vararg elements: Float): ObservableFloatArray = FXCollections.observableFloatArray(*elements)

inline fun FloatArray.toObservableArray(): ObservableFloatArray = FXCollections.observableFloatArray(*this)