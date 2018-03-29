@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.ImageView

inline fun imageView(
    image: Image? = null
): ImageView = imageView(image) { }

inline fun imageView(
    image: Image? = null,
    init: (@LayoutDsl ImageView).() -> Unit
): ImageView = ImageView(image).apply(init)

inline fun LayoutManager<Node>.imageView(
    image: Image? = null
): ImageView = imageView(image) { }

inline fun LayoutManager<Node>.imageView(
    image: Image? = null,
    init: (@LayoutDsl ImageView).() -> Unit
): ImageView = ktfx.layouts.imageView(image, init).add()