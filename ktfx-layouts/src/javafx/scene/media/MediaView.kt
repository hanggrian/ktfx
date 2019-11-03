@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Create a [MediaView] with initialization block. */
inline fun mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDslMarker MediaView).() -> Unit
): MediaView = MediaView(player).apply(init)

/** Add a [MediaView] to this manager. */
fun NodeManager.mediaView(
    player: MediaPlayer? = null
): MediaView = addNode(MediaView(player))

/** Add a [MediaView] with initialization block to this manager. */
inline fun NodeManager.mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDslMarker MediaView).() -> Unit
): MediaView = addNode(MediaView(player), init)
