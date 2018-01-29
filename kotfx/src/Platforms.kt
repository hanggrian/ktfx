@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.application.ConditionalFeature
import javafx.application.Platform
import javafx.application.Platform.isFxApplicationThread
import javafx.application.Platform.isSupported

/** Run the specified block on the JavaFX thread. */
inline fun runLater(noinline block: () -> Unit) = Platform.runLater(block)

/** Returns true if the calling thread is the JavaFX thread. */
inline val isFXThread: Boolean get() = isFxApplicationThread()

@JvmOverloads inline fun exit(status: Int = 0) {
    Platform.exit()
    System.exit(status)
}

/** Queries whether a specific conditional feature is supported by the platform. */
inline val ConditionalFeature.isSupported: Boolean get() = isSupported(this)