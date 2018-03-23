@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

inline fun mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }
inline fun ChildManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()
inline fun ItemManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()
inline fun ButtonManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()