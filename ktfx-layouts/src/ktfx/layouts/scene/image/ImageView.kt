@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.ImageView

/** Create a [ImageView]. */
inline fun imageView(
    image: Image? = null
): ImageView = imageView(image) { }

/** Create a [ImageView] with initialization. */
inline fun imageView(
    image: Image? = null,
    init: (@LayoutDsl ImageView).() -> Unit
): ImageView = ImageView(image).apply(init)

/** Create a [ImageView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.imageView(
    image: Image? = null
): ImageView = imageView(image) { }

/** Create a [ImageView] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.imageView(
    image: Image? = null,
    init: (@LayoutDsl ImageView).() -> Unit
): ImageView = ktfx.layouts.imageView(image, init).add()