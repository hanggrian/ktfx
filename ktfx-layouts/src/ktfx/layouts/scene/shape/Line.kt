@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Line

/** Add a [Line] to this manager. */
fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = Line(centerX, centerY, endX, endY).add()

/** Add a [Line] with initialization block to this manager. */
inline fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDslMarker Line).() -> Unit
): Line = line(centerX, centerY, endX, endY).apply(init)
