@file:JvmName("PlatformsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.application.ConditionalFeature
import javafx.application.Platform

/** Returns true if [features] are all supported. */
inline fun isSupported(vararg features: ConditionalFeature): Boolean {
    require(features.isNotEmpty(), { "Features can't be empty!" })
    return features.all { Platform.isSupported(it) }
}

/** Executes [block] in JavaFX Application Thread. */
inline fun runLater(crossinline block: () -> Unit) = Platform.runLater { block() }

/** Executes [block] in current thread if [features] are all supported. */
inline fun runLaterIfSupported(vararg features: ConditionalFeature, crossinline block: () -> Unit) {
    when {
        isSupported(*features) -> runLater(block)
    }
}

/** Executes [block] in current thread if [features] are all supported, [fallback] otherwise. */
inline fun runLaterIfSupported(vararg features: ConditionalFeature, crossinline block: () -> Unit, crossinline fallback: () -> Unit) {
    when {
        isSupported(*features) -> runLater(block)
        else -> runLater(fallback)
    }
}

/** Executes [block] in JavaFX Application Thread if [features] are all supported. */
inline fun runIfSupported(vararg features: ConditionalFeature, block: () -> Unit) {
    when {
        isSupported(*features) -> block()
    }
}

/** Executes [block] in JavaFX Application Thread if [features] are all supported, [fallback] otherwise. */
inline fun runIfSupported(vararg features: ConditionalFeature, block: () -> Unit, fallback: () -> Unit) {
    when {
        isSupported(*features) -> block()
        else -> fallback()
    }
}

/** Returns [block] if [features] are all supported, null otherwise. */
inline fun <T, R> T.getIfSupported(vararg features: ConditionalFeature, block: T.() -> R): R? {
    return when {
        isSupported(*features) -> block()
        else -> null
    }
}

/** Returns [block] if [features] are all supported, [fallback] otherwise. */
inline fun <T, R> T.getIfSupported(vararg features: ConditionalFeature, block: T.() -> R, fallback: T.() -> R): R {
    return when {
        isSupported(*features) -> block()
        else -> fallback()
    }
}

/** Returns true if calling thread is JavaFX Application Thread. */
inline fun isFXThread(): Boolean = Platform.isFxApplicationThread()

/** Causes the JavaFX application to terminate. */
inline fun exitFX() = Platform.exit()