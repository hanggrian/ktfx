package ktfx

import java.util.concurrent.CountDownLatch
import javafx.application.ConditionalFeature
import javafx.application.Platform

/** Run the specified block in JavaFX thread. */
fun runLater(block: () -> Unit): Unit =
    Platform.runLater(block)

/**
 * Run the specified block in JavaFX thread,
 * bringing receiver type similar to [kotlin.run].
 */
inline fun <T> T.runLater(crossinline block: T.() -> Unit): Unit =
    ktfx.runLater { block() }

/**
 * Run the specified block in JavaFX thread,
 * bringing parameter type similar to [kotlin.let].
 */
inline fun <T> T.letLater(crossinline block: (T) -> Unit): Unit =
    ktfx.runLater { block(this) }

/** Run the specified block in JavaFX thread blocking main thread until [block] is finished. */
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

/**
 * Run the specified block in JavaFX thread blocking main thread until [block] is finished,
 * bringing receiver type similar to [kotlin.run].
 */
inline fun <T> T.runAndWait(crossinline block: T.() -> Unit): Unit =
    ktfx.runAndWait { block() }

/**
 * Run the specified block in JavaFX thread blocking main thread until [block] is finished,
 * bringing parameter type similar to [kotlin.let].
 */
inline fun <T> T.letAndWait(crossinline block: (T) -> Unit): Unit =
    ktfx.runAndWait { block(this) }

/** Returns true if the calling thread is the JavaFX thread. */
fun isFxThread(): Boolean =
    Platform.isFxApplicationThread()

/** Queries whether a specific conditional feature is supported by the platform. */
fun ConditionalFeature.isSupported(): Boolean =
    Platform.isSupported(this)
