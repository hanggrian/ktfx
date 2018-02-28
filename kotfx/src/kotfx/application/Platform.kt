@file:Suppress("NOTHING_TO_INLINE")

package kotfx.application

import javafx.application.ConditionalFeature
import javafx.application.Platform
import javafx.application.Platform.isFxApplicationThread
import javafx.application.Platform.isSupported
import javafx.application.Platform.runLater

/** Run the specified block on the JavaFX thread. */
inline fun later(noinline block: () -> Unit) = runLater(block)

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isFXThread(): Boolean = isFxApplicationThread()

/** Causes JavaFX application and JVM to terminate immediately. */
inline fun exit(status: Int = 0) {
    Platform.exit()
    System.exit(status)
}

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = isSupported(this)