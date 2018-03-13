@file:Suppress("NOTHING_TO_INLINE")

package kfx.util

import javafx.util.Pair

/** Key component of a [Pair] */
inline operator fun <F, S> Pair<F, S>.component1(): F? = key

/** Value component of a [Pair] */
inline operator fun <F, S> Pair<F, S>.component2(): S? = value

/** Converts JavaFX's pair to Kotlin's. */
inline fun <F, S> Pair<F, S>.toKotlinPair(): kotlin.Pair<F, S> = kotlin.Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <F, S> kotlin.Pair<F, S>.toFXPair(): Pair<F, S> = Pair(first, second)