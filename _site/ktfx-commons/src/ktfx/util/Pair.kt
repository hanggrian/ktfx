@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.util.Pair

/** Key component of a [Pair] */
inline operator fun <K, V> Pair<K, V>.component1(): K? = key

/** Value component of a [Pair] */
inline operator fun <K, V> Pair<K, V>.component2(): V? = value

/** Converts JavaFX's pair to Kotlin's. */
inline fun <K, V> Pair<K, V>.toKotlinPair(): kotlin.Pair<K, V> = kotlin.Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <K, V> kotlin.Pair<K, V>.toFXPair(): Pair<K, V> = Pair(first, second)