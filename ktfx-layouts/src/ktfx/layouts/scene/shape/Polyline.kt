@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Polyline

/** Add a [Polyline] to this manager. */
fun NodeManager.polyline(
    vararg points: Double
): Polyline = Polyline(*points).add()

/** Add a [Polyline] with initialization block to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    init: (@LayoutDslMarker Polyline).() -> Unit
): Polyline = polyline(*points).apply(init)
