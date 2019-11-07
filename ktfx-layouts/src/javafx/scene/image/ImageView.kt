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
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ImageView(image).apply(init)
}
/** Create an [ImageView] with initialization block. */
inline fun imageView(
    imageUrl: String,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ImageView(imageUrl).apply(init)
}
/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    image: Image? = null
): ImageView = addNode(ImageView(image))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ImageView(image), init)
}
/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    imageUrl: String
): ImageView = addNode(ImageView(imageUrl))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ImageView(imageUrl), init)
}
