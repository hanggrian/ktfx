@file:Suppress("NOTHING_TO_INLINE")

package ktfx

/**
 * Returns the key component of the pair.
 *
 * This method allows to use destructuring declarations when working with pairs
 *   (e.g.: `val (first, second) = myPair`).
 */
inline operator fun <F, S> javafx.util.Pair<F, S>.component1(): F? = key

/**
 * Returns the value component of the pair.
 *
 * This method allows to use destructuring declarations when working with pairs
 *   (e.g.: `val (first, second) = myPair`).
 */
inline operator fun <F, S> javafx.util.Pair<F, S>.component2(): S? = value

/** Returns this [Pair] as a [kotlin.Pair]. */
inline fun <F, S> javafx.util.Pair<F, S>.toKotlinPair(): Pair<F, S> = Pair(key, value)

/** Returns this [kotlin.Pair] as a JavaFX [Pair]. */
inline fun <F, S> Pair<F, S>.toFxPair(): javafx.util.Pair<F, S> = javafx.util.Pair(first, second)
