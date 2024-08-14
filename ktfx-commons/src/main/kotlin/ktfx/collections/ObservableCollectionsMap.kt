@file:JvmMultifileClass
@file:JvmName("ObservableCollectionsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableMap
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Returns an empty read-only [ObservableMap].
 *
 * @see emptyMap
 */
public inline fun <K, V> emptyObservableMap(): ObservableMap<K, V> =
    FXCollections.emptyObservableMap()

/**
 * Returns a new read-only [ObservableMap] of given pairs.
 *
 * @see mapOf
 */
public fun <K, V> observableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> =
    if (pairs.isNotEmpty()) {
        FXCollections.unmodifiableObservableMap(pairs.toMap(FXCollections.observableHashMap()))
    } else {
        emptyObservableMap()
    }

/**
 * Returns an empty read-only [ObservableMap].
 *
 * @see mapOf
 */
public inline fun <K, V> observableMapOf(): ObservableMap<K, V> = emptyObservableMap()

/**
 * Returns an empty [ObservableMap].
 *
 * @see mutableMapOf
 */
public inline fun <K, V> mutableObservableMapOf(): ObservableMap<K, V> =
    FXCollections.observableHashMap()

/**
 * Returns a new [ObservableMap] with the given elements.
 *
 * @see mutableMapOf
 */
public fun <K, V> mutableObservableMapOf(vararg pairs: Pair<K, V>): ObservableMap<K, V> =
    if (pairs.isEmpty()) {
        mutableObservableMapOf()
    } else {
        FXCollections.observableMap(
            HashMap<K, V>().apply {
                for ((key, value) in pairs) put(key, value)
            },
        )
    }

/**
 * Builds a new read-only [ObservableMap] by populating a [MutableMap] using the
 * given [builderAction] and returning a read-only map with the same elements.
 *
 * @see buildMap
 */
@ExperimentalStdlibApi
public inline fun <K, V> buildObservableMap(builderAction: MutableMap<K, V>.() -> Unit): Map<K, V> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return buildMap(builderAction).toObservableMap()
}

/**
 * Returns an [ObservableMap] containing all elements.
 *
 * @see Map.toMap
 */
public fun <K, V> Map<K, V>.toObservableMap(): ObservableMap<K, V> =
    when (size) {
        0 -> emptyObservableMap()
        else -> FXCollections.unmodifiableObservableMap(this.toMutableObservableMap())
    }

/**
 * Returns a new [ObservableMap] filled with all elements of this map.
 *
 * @see Map.toMutableMap
 */
public inline fun <K, V> Map<K, V>.toMutableObservableMap(): ObservableMap<K, V> =
    FXCollections.observableMap(this)
