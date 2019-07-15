@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.CountDownLatch
import javafx.application.ConditionalFeature
import javafx.application.Platform

/** Run the specified block on the JavaFX thread runLater. */
inline fun runLater(noinline block: () -> Unit): Unit = Platform.runLater(block)

/** Run the specified block immediately if caller is already in JavaFX thread, or later if it's not. */
fun runAndWait(block: () -> Unit): Unit = when {
    isFxThread() -> block()
    else -> {
        val doneLatch = CountDownLatch(1)
        runLater {
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
}

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isFxThread(): Boolean = Platform.isFxApplicationThread()

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)
