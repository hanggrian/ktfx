@file:Suppress("NOTHING_TO_INLINE")

package kfx.application

import com.sun.javafx.application.PlatformImpl
import javafx.application.ConditionalFeature
import javafx.application.Platform

/** Run the specified block on the JavaFX thread. */
inline fun later(noinline block: () -> Unit) = Platform.runLater(block)

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isFXThread(): Boolean = Platform.isFxApplicationThread()

/** Causes JavaFX application and JVM to terminate immediately. */
inline fun exit(status: Int = 0) {
    Platform.exit()
    System.exit(status)
}

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)

fun initToolkit(startup: (() -> Unit)? = null) = PlatformImpl.startup { startup?.invoke() }