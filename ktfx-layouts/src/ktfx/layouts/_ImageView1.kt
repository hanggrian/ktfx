@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.image.ImageView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add an [ImageView] to this manager.
 */
fun NodeManager.imageView(imageUrl: String): ImageView = imageView(imageUrl = imageUrl) { }

/**
 * Create an [ImageView] with configuration block.
 */
inline fun imageView(imageUrl: String, configuration: (@LayoutDslMarker ImageView).() -> Unit):
        ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ImageView(imageUrl), configuration = configuration)
}

/**
 * Add an [ImageView] with configuration block to this manager.
 */
inline fun NodeManager.imageView(
    imageUrl: String,
    configuration: (@LayoutDslMarker ImageView).() ->    
            Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ImageView(imageUrl), configuration = configuration))
}

/**
 * Create a styled [ImageView].
 */
fun styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null
): ImageView = styledImageView(imageUrl = imageUrl, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ImageView] to this manager.
 */
fun NodeManager.styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null
): ImageView = styledImageView(imageUrl = imageUrl, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ImageView] with configuration block.
 */
inline fun styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ImageView(imageUrl), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [ImageView] with configuration block to this manager.
 */
inline fun NodeManager.styledImageView(
    imageUrl: String,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ImageView(imageUrl), styleClass = *styleClass, id = id, configuration =
            configuration))
}
