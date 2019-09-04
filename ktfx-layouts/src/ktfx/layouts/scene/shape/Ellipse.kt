@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Ellipse

/** Add an [Ellipse] to this manager. */
fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY).add()

/** Add an [Ellipse] with initialization block to this manager. */
inline fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: (@LayoutDslMarker Ellipse).() -> Unit
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY).apply(init)
