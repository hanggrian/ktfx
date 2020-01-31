@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.util.Pair

/**
 * Returns the key component of the pair.
 *
 * This method allows to use destructuring declarations when working with pairs (e.g.: `val (first, second) = myPair`).
 */
inline operator fun <F, S> Pair<F, S>.component1(): F? = key

/**
 * Returns the value component of the pair.
 *
 * This method allows to use destructuring declarations when working with pairs (e.g.: `val (first, second) = myPair`).
 */
inline operator fun <F, S> Pair<F, S>.component2(): S? = value

/** Returns this [Pair] as a [kotlin.Pair]. */
inline fun <F, S> Pair<F, S>.toKotlinPair(): kotlin.Pair<F, S> = kotlin.Pair(key, value)

/** Returns this [kotlin.Pair] as an JavaFX [Pair]. */
inline fun <F, S> kotlin.Pair<F, S>.toFxPair(): Pair<F, S> = Pair(first, second)
