@file:JvmMultifileClass
@file:JvmName("CollectionsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.FXCollections
import javafx.collections.FXCollections.*
import javafx.collections.ObservableMap

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

/** Returns an empty immutable [ObservableMap]. */
inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

/** Returns an empty observable map of containing all [pairs]. */
inline fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = if (pairs.isNotEmpty()) unmodifiableObservableMap(mutableObservableMapOf(*pairs)) else emptyObservableMap()

/** Converts this map to immutable [ObservableMap]. */
inline fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> = unmodifiableObservableMap(toMutableObservableMap())

/** Returns an empty [[ObservableMap]]. */
inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> = observableHashMap()

/** Returns an [[ObservableMap]] of [pairs]. */
inline fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = observableMap(HashMap<K, V>().apply { for ((key, value) in pairs) put(key, value) })

/** Converts this map to [[ObservableMap]]. */
inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = observableMap(this)