@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create an [ImageView] with configuration block. */
inline fun imageView(
    image: Image? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ImageView(image).apply(configuration)
}

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    image: Image? = null
): ImageView = addChild(ImageView(image))

/** Add an [ImageView] with configuration block to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ImageView(image), configuration)
}

/** Create an [ImageView] with configuration block. */
inline fun imageView(
    imageUrl: String,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return imageView(Image(imageUrl), configuration)
}

/** Add an [ImageView] to this manager. */
@Suppress("NOTHING_TO_INLINE")
inline fun NodeManager.imageView(
    imageUrl: String
): ImageView = imageView(Image(imageUrl))

/** Add an [ImageView] with configuration block to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return imageView(Image(imageUrl), configuration)
}
