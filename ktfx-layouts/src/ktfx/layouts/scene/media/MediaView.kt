@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [MediaView]. */
fun mediaView(
    player: MediaPlayer? = null,
    init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = MediaView(player).also { init?.invoke(it) }

/** Creates a [MediaView] and add it to this manager. */
inline fun NodeManager.mediaView(
    player: MediaPlayer? = null,
    noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = ktfx.layouts.mediaView(player, init)()