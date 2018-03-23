@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

inline fun mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }

inline fun Manager<Node>.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()