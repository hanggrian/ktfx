@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView

inline fun imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }
inline fun ChildManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()
inline fun ItemManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()
inline fun ButtonManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()