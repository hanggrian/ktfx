@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.util

import javafx.util.Pair

@Suppress("HasPlatformType") // unknown nullability
inline operator fun <F, S> Pair<F, S>.component1() = key

@Suppress("HasPlatformType") // unknown nullability
inline operator fun <F, S> Pair<F, S>.component2() = value

/** Converts JavaFX's pair to Kotlin's. */
inline fun <F, S> Pair<F, S>.toKotlinPair(): kotlin.Pair<F, S> = kotlin.Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <F, S> kotlin.Pair<F, S>.toFXPair(): Pair<F, S> = Pair(first, second)