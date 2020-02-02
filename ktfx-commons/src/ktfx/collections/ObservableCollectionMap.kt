@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableMap

/**
 * Returns an empty immutable [ObservableMap].
 *
 * @see emptyMap
 */
inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> = FXCollections.emptyObservableMap()

/**
 * Returns an empty immutable [ObservableMap].
 *
 * @see mapOf
 */
inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

/**
 * Returns an empty observable map of containing all [pairs].
 *
 * @see mapOf
 */
fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = when {
    pairs.isNotEmpty() -> FXCollections.unmodifiableObservableMap(pairs.toMap(FXCollections.observableHashMap()))
    else -> emptyObservableMap()
}

/**
 * Returns an empty [ObservableMap].
 *
 * @see mutableMapOf
 */
inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> = FXCollections.observableHashMap()

/**
 * Returns an [ObservableMap] of [pairs].
 *
 * @see mutableMapOf
 */
fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> = when {
    pairs.isEmpty() -> mutableObservableMapOf()
    else -> FXCollections.observableMap(HashMap<K, V>().apply {
        for ((key, value) in pairs) put(key, value)
    })
}

/**
 * Converts this map to immutable [ObservableMap].
 *
 * @see Map.toMap
 */
fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> = when (size) {
    0 -> emptyObservableMap()
    else -> FXCollections.unmodifiableObservableMap(this.toMutableObservableMap())
}

/**
 * Converts this map to [ObservableMap].
 *
 * @see Map.toMutableMap
 */
inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> = FXCollections.observableMap(this)
