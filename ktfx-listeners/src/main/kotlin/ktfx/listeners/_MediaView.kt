@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see MediaView.setOnError
 */
public inline fun MediaView.onError(noinline action: (MediaErrorEvent) -> Unit): Unit =
        setOnError(action)
