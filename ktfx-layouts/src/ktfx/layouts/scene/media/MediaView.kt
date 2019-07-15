@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Creates a [MediaView]. */
fun mediaView(
    player: MediaPlayer? = null,
    init: ((@LayoutDslMarker MediaView).() -> Unit)? = null
): MediaView = MediaView(player).also { init?.invoke(it) }

/** Creates a [MediaView] and add it to this manager. */
inline fun NodeManager.mediaView(
    player: MediaPlayer? = null,
    noinline init: ((@LayoutDslMarker MediaView).() -> Unit)? = null
): MediaView = ktfx.layouts.mediaView(player, init).add()
