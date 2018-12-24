@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.application.ConditionalFeature
import javafx.application.Platform
import java.util.concurrent.CountDownLatch

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isInFx(): Boolean = Platform.isFxApplicationThread()

/** Run the specified block on the JavaFX thread later. */
inline fun later(noinline block: () -> Unit): Unit = Platform.runLater(block)

/** Run the specified block immediately if caller is already in JavaFX thread, or later if it's not. */
fun now(block: () -> Unit): Unit = ifInFx(block) { later(block) }

/** Run the specified block immediately if caller is already in JavaFX thread, or later and wait until it finishes. */
fun wait(block: () -> Unit): Unit = ifInFx(block) {
    val doneLatch = CountDownLatch(1)
    later {
        try {
            block()
        } finally {
            doneLatch.countDown()
        }
    }
    try {
        doneLatch.await()
    } catch (e: InterruptedException) {
        Thread.currentThread().interrupt()
    }
}

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)

private inline fun ifInFx(block: () -> Unit, fallback: () -> Unit): Unit = if (isInFx()) block() else fallback()