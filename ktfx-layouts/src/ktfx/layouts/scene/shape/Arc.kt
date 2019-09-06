@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Arc

/** Create an [Arc] with initialization block. */
inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutDslMarker Arc).() -> Unit
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply(init)

/** Add an [Arc] to this manager. */
fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = addNode(ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length) { })

/** Add an [Arc] with initialization block to this manager. */
inline fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutDslMarker Arc).() -> Unit
): Arc = addNode(ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init))
