@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.application.ConditionalFeature
import javafx.application.Platform.*

/** Run the specified block on the JavaFX thread. */
inline fun run(noinline block: () -> Unit) = runLater(block)

/** Returns true if the calling thread is the JavaFX thread. */
inline val isFXThread: Boolean get() = isFxApplicationThread()

/** Queries whether a specific conditional feature is supported by the platform. */
inline val ConditionalFeature.isSupported: Boolean get() = isSupported(this)