@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Creates an [ImageView]. */
fun imageView(
    image: Image? = null,
    init: ((@LayoutDslMarker ImageView).() -> Unit)? = null
): ImageView = ImageView(image).also { init?.invoke(it) }

/** Creates an [ImageView]. */
fun imageView(
    imageUrl: String,
    init: ((@LayoutDslMarker ImageView).() -> Unit)? = null
): ImageView = ImageView(imageUrl).also { init?.invoke(it) }

/** Creates an [ImageView] and add it to this manager. */
inline fun NodeManager.imageView(
    image: Image? = null,
    noinline init: ((@LayoutDslMarker ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(image, init).add()

/** Creates an [ImageView] and add it to this manager. */
inline fun NodeManager.imageView(
    imageUrl: String,
    noinline init: ((@LayoutDslMarker ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(imageUrl, init).add()
