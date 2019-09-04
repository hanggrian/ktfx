@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

/** Add a [Circle] to this manager. */
fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = Circle(centerX, centerY, radius, fill).add()

/** Add a [Circle] with initialization block to this manager. */
inline fun NodeManager.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: (@LayoutDslMarker Circle).() -> Unit
): Circle = circle(centerX, centerY, radius, fill).apply(init)
