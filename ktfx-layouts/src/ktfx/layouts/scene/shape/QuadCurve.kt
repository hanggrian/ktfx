@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.QuadCurve

/** Add a [QuadCurve] to this manager. */
fun NodeManager.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).add()

/** Add a [QuadCurve] with initialization block to this manager. */
inline fun NodeManager.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDslMarker QuadCurve).() -> Unit
): QuadCurve = quadCurve(startX, startY, controlX, controlY, endX, endY).apply(init)
