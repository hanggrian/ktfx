@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.image.Image
import javafx.scene.image.ImageView

inline fun imageView(
    image: Image? = null,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).also { init?.invoke(it) }

inline fun LayoutManager<Node>.imageView(
    image: Image? = null,
    noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null
): ImageView = ktfx.layouts.imageView(image, init).add()