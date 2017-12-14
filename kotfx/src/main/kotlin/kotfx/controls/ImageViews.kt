@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Rectangle2D
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotfx._Pane
import kotfx._Node
import kotfx.internal.ControlDsl

class _ImageView(image: Image?) : ImageView(image), _Node<ImageView> {
    override val node: ImageView get() = this

    fun image(value: Image) = setImage(value)
    fun x(value: Number) = setX(value.toDouble())
    fun y(value: Number) = setY(value.toDouble())
    fun fitWidth(value: Number) = setFitWidth(value.toDouble())
    fun fitHeight(value: Number) = setFitWidth(value.toDouble())
    fun preserveRatio(value: Boolean) = setPreserveRatio(value)
    fun smooth(value: Boolean) = setSmooth(value)
    fun viewport(value: Rectangle2D) = setViewport(value)
}

@JvmOverloads
inline fun imageViewOf(
        image: Image? = null,
        noinline init: ((@ControlDsl _ImageView).() -> Unit)? = null
): ImageView = _ImageView(image).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.imageView(
        image: Image? = null,
        noinline init: ((@ControlDsl _ImageView).() -> Unit)? = null
): ImageView = imageViewOf(image, init).add()