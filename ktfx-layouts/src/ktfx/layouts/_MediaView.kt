@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MediaView] to this manager.
 */
fun NodeManager.mediaView(mediaPlayer: MediaPlayer? = null): MediaView = mediaView(mediaPlayer =
        mediaPlayer) { }

/**
 * Create a [MediaView] with configuration block.
 */
inline fun mediaView(
    mediaPlayer: MediaPlayer? = null,
    configuration: (@LayoutDslMarker    
            MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MediaView(mediaPlayer), configuration = configuration)
}

/**
 * Add a [MediaView] with configuration block to this manager.
 */
inline fun NodeManager.mediaView(
    mediaPlayer: MediaPlayer? = null,
    configuration: (@LayoutDslMarker    
            MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MediaView(mediaPlayer), configuration = configuration))
}

/**
 * Create a styled [MediaView].
 */
fun styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null
): MediaView = styledMediaView(mediaPlayer = mediaPlayer, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MediaView] to this manager.
 */
fun NodeManager.styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null
): MediaView = styledMediaView(mediaPlayer = mediaPlayer, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MediaView] with configuration block.
 */
inline fun styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MediaView(mediaPlayer), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [MediaView] with configuration block to this manager.
 */
inline fun NodeManager.styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MediaView).() -> Unit
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MediaView(mediaPlayer), styleClass = *styleClass, id = id,
            configuration = configuration))
}
