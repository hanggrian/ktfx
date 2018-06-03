@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Creates a [ImageView]. */
fun imageView(
    image: Image? = null,
    init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).also {
    init?.invoke(it)
}

/** Creates a [ImageView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.imageView(
    image: Image? = null,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(image, init)()

/** Create a styled [ImageView]. */
fun styledImageView(
    styleClass: String,
    image: Image? = null,
    init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ImageView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledImageView(
    styleClass: String,
    image: Image? = null,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.styledImageView(styleClass, image, init)()