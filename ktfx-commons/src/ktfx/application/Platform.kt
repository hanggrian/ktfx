@file:Suppress("NOTHING_TO_INLINE")

package ktfx.application

import javafx.application.ConditionalFeature

/** Application platform support class. */
typealias Platform = com.sun.javafx.application.PlatformImpl

/**
 * Returns true if the calling thread is the JavaFX thread.
 * Alias of `Platform.isFxApplicationThread`.
 */
inline fun isFXThread(): Boolean = Platform.isFxApplicationThread()

/**
 * Run the specified block on the JavaFX thread.
 * Alias of `Platform.runLater`.
 */
inline fun later(noinline block: () -> Unit) = Platform.runLater(block)

/**
 * Run and wait the specified block on the JavaFX thread.
 * Alias of `Platform.runAndWait`.
 */
inline fun wait(noinline block: () -> Unit) = Platform.runAndWait(block)

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)