@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Create an [ImageView] with initialization block. */
inline fun imageView(
    image: Image? = null,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = ImageView(image).apply(init)

/** Create an [ImageView] with initialization block. */
inline fun imageView(
    imageUrl: String,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = ImageView(imageUrl).apply(init)

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    image: Image? = null
): ImageView = addNode(ImageView(image))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = addNode(ImageView(image), init)

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    imageUrl: String
): ImageView = addNode(ImageView(imageUrl))

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = addNode(ImageView(imageUrl), init)
