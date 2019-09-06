@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.ArcTo

/** Create an [ArcTo] with initialization block. */
inline fun arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    init: (@LayoutDslMarker ArcTo).() -> Unit
): ArcTo = ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag).apply(init)

/** Add an [ArcTo] to this manager. */
fun PathElementManager.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false
): ArcTo = addElement(ktfx.layouts.arcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag) { })

/** Add an [ArcTo] with initialization block to this manager. */
inline fun PathElementManager.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    init: (@LayoutDslMarker ArcTo).() -> Unit
): ArcTo = addElement(ktfx.layouts.arcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag, init))
