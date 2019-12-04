@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create an [ImageView] with initialization block. */
inline fun imageView(
    image: Image? = null,
    init: (@LayoutsDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ImageView(image).apply(init)
}

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    image: Image? = null
): ImageView = addChild(ImageView(image))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    init: (@LayoutsDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(ImageView(image), init)
}

/** Create an [ImageView] with initialization block. */
inline fun imageView(
    imageUrl: String,
    init: (@LayoutsDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return imageView(Image(imageUrl), init)
}

/** Add an [ImageView] to this manager. */
@Suppress("NOTHING_TO_INLINE")
inline fun NodeManager.imageView(
    imageUrl: String
): ImageView = imageView(Image(imageUrl))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    init: (@LayoutsDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return imageView(Image(imageUrl), init)
}
