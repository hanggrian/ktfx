@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Creates an [ImageView]. */
fun imageView(
    image: Image? = null,
    init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).also { init?.invoke(it) }

/** Creates an [ImageView]. */
fun imageView(
    imageUrl: String,
    init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(imageUrl).also { init?.invoke(it) }

/** Creates an [ImageView] and add it to this manager. */
inline fun NodeInvokable.imageView(
    image: Image? = null,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(image, init)()

/** Creates an [ImageView] and add it to this manager. */
inline fun NodeInvokable.imageView(
    imageUrl: String,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(imageUrl, init)()