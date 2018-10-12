@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Creates a [MediaView]. */
fun mediaView(
    player: MediaPlayer? = null,
    init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = MediaView(player).also { init?.invoke(it) }

/** Creates a [MediaView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null,
    noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = ktfx.layouts.mediaView(player, init)()