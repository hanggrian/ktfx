@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Arc

/** Add an [Arc] to this manager. */
fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).add()

/** Add an [Arc] with initialization block to this manager. */
inline fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutDslMarker Arc).() -> Unit
): Arc = arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply(init)
