@file:JvmMultifileClass
@file:JvmName("PlatformKt")

package ktfx

import javafx.application.ConditionalFeature
import javafx.application.Platform

/** Returns true if the calling thread is the JavaFX thread. */
fun isFxThread(): Boolean =
    Platform.isFxApplicationThread()

/** Queries whether a specific conditional feature is supported by the platform. */
fun ConditionalFeature.isSupported(): Boolean =
    Platform.isSupported(this)
