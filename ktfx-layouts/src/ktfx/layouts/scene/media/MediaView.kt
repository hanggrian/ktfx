@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Add a [MediaView] to this manager. */
fun NodeManager.mediaView(
    player: MediaPlayer? = null
): MediaView = MediaView(player).add()

/** Add a [MediaView] with initialization block to this manager. */
inline fun NodeManager.mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDslMarker MediaView).() -> Unit
): MediaView = mediaView(player).apply(init)
