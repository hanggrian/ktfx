@file:JvmMultifileClass
@file:JvmName("FXCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableMap

/** Returns an empty read-only observable map. */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

inline fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = if (pairs.isNotEmpty()) FXCollections.unmodifiableObservableMap(mutableObservableMapOf(*pairs)) else emptyObservableMap()

inline fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> = FXCollections.unmodifiableObservableMap(toMutableObservableMap())

inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> = FXCollections.observableHashMap()

inline fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = FXCollections.observableMap(HashMap<K, V>().apply { for ((key, value) in pairs) put(key, value) })

inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = FXCollections.observableMap(this)