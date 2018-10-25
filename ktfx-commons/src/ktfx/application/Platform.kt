@file:Suppress("NOTHING_TO_INLINE")

package ktfx.application

import javafx.application.ConditionalFeature
import javafx.application.Platform
import java.util.concurrent.CountDownLatch

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isFxThread(): Boolean = Platform.isFxApplicationThread()

/** Run the specified block on the JavaFX thread. */
inline fun later(noinline block: () -> Unit): Unit = Platform.runLater(block)

/** Run the specified block on the JavaFX thread and wait until it finishes. */
fun wait(block: () -> Unit) {
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