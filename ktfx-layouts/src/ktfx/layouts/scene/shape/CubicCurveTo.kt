@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.CubicCurveTo

/** Create a [CubicCurveTo] with initialization block. */
inline fun cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo = CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y).apply(init)

/** Add a [CubicCurveTo] to this manager. */
fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0
): CubicCurveTo = addElement(CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y))

/** Add a [CubicCurveTo] with initialization block to this manager. */
inline fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: (@LayoutDslMarker CubicCurveTo).() -> Unit
): CubicCurveTo = addElement(CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y), init)
