@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.collections.ObservableList
import javafx.util.Pair
import ktfx.collections.observableListOf

/** Key of this pair. */
inline operator fun <K, V> Pair<K, V>.component1(): K? = key

/** Value of this pair. */
inline operator fun <K, V> Pair<K, V>.component2(): V? = value

/** Converts JavaFX pair to Kotlin's. */
fun <K, V> Pair<K, V>.toKotlinPair(): kotlin.Pair<K, V> = kotlin.Pair(key, value)

/** Converts Kotlin pair to JavaFX's. */
fun <K, V> kotlin.Pair<K, V>.toFxPair(): Pair<K, V> = Pair(first, second)

/**
 * Converts this pair into an observable list.
 *
 * @see kotlin.toList
 */
fun <T> kotlin.Pair<T, T>.toObservableList(): ObservableList<T> = observableListOf(first, second)
