@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MediaView] with initialization block. */
inline fun mediaView(
    mediaPlayer: MediaPlayer? = null,
    init: (@LayoutsDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MediaView(mediaPlayer).apply(init)
}

/** Add a [MediaView] to this manager. */
fun NodeManager.mediaView(
    mediaPlayer: MediaPlayer? = null
): MediaView = addChild(MediaView(mediaPlayer))

/** Add a [MediaView] with initialization block to this manager. */
inline fun NodeManager.mediaView(
    mediaPlayer: MediaPlayer? = null,
    init: (@LayoutsDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(MediaView(mediaPlayer), init)
}
