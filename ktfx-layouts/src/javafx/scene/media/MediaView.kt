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
    player: MediaPlayer? = null,
    init: MediaView.() -> Unit
): MediaView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MediaView(player).apply(init)
}

/** Add a [MediaView] to this manager. */
fun NodeManager.mediaView(
    player: MediaPlayer? = null
): MediaView = addNode(MediaView(player))

/** Add a [MediaView] with initialization block to this manager. */
inline fun NodeManager.mediaView(
    player: MediaPlayer? = null,
    init: MediaView.() -> Unit
): MediaView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(MediaView(player), init)
}
