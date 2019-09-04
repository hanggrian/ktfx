@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.CubicCurve

/** Add a [CubicCurve] to this manager. */
fun NodeManager.cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): CubicCurve =
    cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).add()

/** Add a [CubicCurve] with initialization block to this manager. */
inline fun NodeManager.cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDslMarker CubicCurve).() -> Unit
): CubicCurve =
    cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply(init)
