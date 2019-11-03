@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.shape.VLineTo

/** Create a [VLineTo] with initialization block. */
inline fun vlineTo(
    y: Double = 0.0,
    init: (@LayoutDslMarker VLineTo).() -> Unit
): VLineTo = VLineTo(y).apply(init)

/** Add a [VLineTo] to this manager. */
fun PathElementManager.vlineTo(
    y: Double = 0.0
): VLineTo = addElement(VLineTo(y))

/** Add a [VLineTo] with initialization block to this manager. */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    init: (@LayoutDslMarker VLineTo).() -> Unit
): VLineTo = addElement(VLineTo(y), init)
