@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

inline fun mediaView(
    player: MediaPlayer? = null
): MediaView = mediaView(player) { }

inline fun mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDsl MediaView).() -> Unit
): MediaView = MediaView(player).apply(init)

inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null
): MediaView = mediaView(player) { }

inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null,
    init: (@LayoutDsl MediaView).() -> Unit
): MediaView = ktfx.layouts.mediaView(player, init).add()