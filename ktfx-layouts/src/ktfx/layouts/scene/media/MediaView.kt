@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Create a [MediaView]. */
inline fun mediaView(
    player: MediaPlayer? = null
): MediaView = mediaView(player) { }

/** Create a [MediaView] with initialization. */
inline fun mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDsl MediaView).() -> Unit
): MediaView = MediaView(player).apply(init)

/** Create a [MediaView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null
): MediaView = mediaView(player) { }

/** Create a [MediaView] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDsl MediaView).() -> Unit
): MediaView = ktfx.layouts.mediaView(player, init).add()