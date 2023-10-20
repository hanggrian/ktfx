@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MediaView] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.mediaView(mediaPlayer: MediaPlayer? = null): MediaView =
        mediaView(mediaPlayer = mediaPlayer) { }

/**
 * Create a [MediaView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun mediaView(mediaPlayer: MediaPlayer? = null, configuration: (@KtfxLayoutDslMarker
        MediaView).() -> Unit): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MediaView(mediaPlayer)
    child.configuration()
    return child
}

/**
 * Add a [MediaView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.mediaView(mediaPlayer: MediaPlayer? = null,
        configuration: (@KtfxLayoutDslMarker MediaView).() -> Unit): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MediaView(mediaPlayer)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [MediaView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
): MediaView = styledMediaView(mediaPlayer = mediaPlayer, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MediaView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
): MediaView = styledMediaView(mediaPlayer = mediaPlayer, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MediaView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MediaView).() -> Unit,
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MediaView(mediaPlayer)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MediaView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMediaView(
    mediaPlayer: MediaPlayer? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MediaView).() -> Unit,
): MediaView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MediaView(mediaPlayer)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
