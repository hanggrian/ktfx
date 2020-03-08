@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MediaView] with configuration block. */
inline fun mediaView(
    mediaPlayer: MediaPlayer? = null,
    configuration: (@LayoutDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MediaView(mediaPlayer).apply(configuration)
}

/** Add a [MediaView] to this manager. */
fun NodeManager.mediaView(
    mediaPlayer: MediaPlayer? = null
): MediaView = addChild(MediaView(mediaPlayer))

/** Add a [MediaView] with configuration block to this manager. */
inline fun NodeManager.mediaView(
    mediaPlayer: MediaPlayer? = null,
    configuration: (@LayoutDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(MediaView(mediaPlayer), configuration)
}
