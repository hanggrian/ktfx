@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.image.ImageView
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
 * Add an [ImageView] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.imageView(imageUrl: String): ImageView = imageView(imageUrl = imageUrl) { }

/**
 * Create an [ImageView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun imageView(imageUrl: String, configuration: (@KtfxLayoutDslMarker
        ImageView).() -> Unit): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ImageView(imageUrl)
    child.configuration()
    return child
}

/**
 * Add an [ImageView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.imageView(imageUrl: String, configuration: (@KtfxLayoutDslMarker
        ImageView).() -> Unit): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ImageView(imageUrl)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ImageView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
): ImageView = styledImageView(imageUrl = imageUrl, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ImageView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
): ImageView = styledImageView(imageUrl = imageUrl, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ImageView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ImageView).() -> Unit,
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ImageView(imageUrl)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ImageView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ImageView).() -> Unit,
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ImageView(imageUrl)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
