@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo

/** Create a [QuadCurveTo]  with initialization block. */
inline fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo = QuadCurveTo(controlX, controlY, x, y).apply(init)

/** Add a [QuadCurveTo] to this manager. */
fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): QuadCurveTo = addElement(QuadCurveTo(controlX, controlY, x, y))

/** Add a [QuadCurveTo]  with initialization block to this manager. */
inline fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker QuadCurveTo).() -> Unit
): QuadCurveTo = addElement(QuadCurveTo(controlX, controlY, x, y), init)
