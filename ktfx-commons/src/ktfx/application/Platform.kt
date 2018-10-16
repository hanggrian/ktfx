@file:Suppress("NOTHING_TO_INLINE")

package ktfx.application

import javafx.application.ConditionalFeature
import javafx.application.Platform

/**
 * Returns true if the calling thread is the JavaFX thread.
 * Alias of `Platform.isFxApplicationThread`.
 */
inline fun isFxThread(): Boolean = Platform.isFxApplicationThread()

/**
 * Run the specified block on the JavaFX thread.
 * Alias of `Platform.runLater`.
 */
inline fun later(noinline block: () -> Unit): Unit = Platform.runLater(block)

/**
 * @see kotlin.run
 */
inline fun <T> T.runLater(noinline block: T.() -> Unit): Unit = later { run(block) }

/**
 * @see kotlin.let
 */
inline fun <T> T.letLater(noinline block: (T) -> Unit): Unit = later { let(block) }

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)