@file:Suppress("NOTHING_TO_INLINE")

package kotfx

/** Converts JavaFX's pair to Kotlin's. */
inline fun <K, V> javafx.util.Pair<K, V>.toKotlinPair(): Pair<K, V> = Pair(key, value)

/** Converts Kotlin's pair to JavaFX's. */
inline fun <K, V> Pair<K, V>.toFXPair(): javafx.util.Pair<K, V> = javafx.util.Pair(first, second)