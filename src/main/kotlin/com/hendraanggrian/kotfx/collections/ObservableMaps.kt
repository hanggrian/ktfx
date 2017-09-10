@file:JvmMultifileClass
@file:JvmName("FxCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableMap

/** Returns an empty read-only observable map. */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

/** Returns a read-only observable map containing all elements. */
inline fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> = FXCollections.unmodifiableObservableMap(toMutableObservableMap())

/** Returns a observable map containing all elements. */
inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = FXCollections.observableMap(this)