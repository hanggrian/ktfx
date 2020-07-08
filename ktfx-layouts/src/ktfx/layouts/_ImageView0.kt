@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [ImageView] to this manager.
 */
fun NodeManager.imageView(image: Image? = null): ImageView = imageView(image = image) { }

/**
 * Create an [ImageView] with configuration block.
 */
inline fun imageView(image: Image? = null, configuration: (@LayoutDslMarker ImageView).() -> Unit):
    ImageView {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(ImageView(image), configuration = configuration)
    }

/**
 * Add an [ImageView] with configuration block to this manager.
 */
inline fun NodeManager.imageView(
    image: Image? = null,
    configuration: (
        @LayoutDslMarker    
        ImageView
    ).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ImageView(image), configuration = configuration))
}

/**
 * Create a styled [ImageView].
 */
fun styledImageView(
    image: Image? = null,
    vararg styleClass: String,
    id: String? = null
): ImageView = styledImageView(image = image, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ImageView] to this manager.
 */
fun NodeManager.styledImageView(
    image: Image? = null,
    vararg styleClass: String,
    id: String? = null
): ImageView = styledImageView(image = image, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ImageView] with configuration block.
 */
inline fun styledImageView(
    image: Image? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ImageView(image), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ImageView] with configuration block to this manager.
 */
inline fun NodeManager.styledImageView(
    image: Image? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ImageView(image), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
