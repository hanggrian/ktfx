@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun imageView(
        image: Image? = null,
        noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.imageView(
        image: Image? = null,
        noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.imageView(
        image: Image? = null,
        noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).apply { init?.invoke(this) }.add()