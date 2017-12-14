@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun imageView(
        image: Image? = null,
        noinline init: ((@ControlDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.imageView(
        image: Image? = null,
        noinline init: ((@ControlDsl ImageView).() -> Unit)? = null
): ImageView = ImageView(image).apply { init?.invoke(this) }.add()