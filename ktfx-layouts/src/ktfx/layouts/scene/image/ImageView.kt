@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    image: Image? = null
): ImageView = ImageView(image).add()

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = imageView(image).apply(init)

/** Add an [ImageView] to this manager. */
fun NodeManager.imageView(
    imageUrl: String
): ImageView = ImageView(imageUrl).add()

/** Add an [ImageView] with initialization block to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    init: (@LayoutDslMarker ImageView).() -> Unit
): ImageView = imageView(imageUrl).apply(init)
