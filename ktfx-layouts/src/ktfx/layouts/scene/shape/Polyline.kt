@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Polyline

/** Create a [Polyline] with initialization block. */
inline fun polyline(
    vararg points: Double,
    init: (@LayoutDslMarker Polyline).() -> Unit
): Polyline = Polyline(*points).apply(init)

/** Add a [Polyline] to this manager. */
fun NodeManager.polyline(
    vararg points: Double
): Polyline = addNode(ktfx.layouts.polyline(*points) { })

/** Add a [Polyline] with initialization block to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    init: (@LayoutDslMarker Polyline).() -> Unit
): Polyline = addNode(ktfx.layouts.polyline(*points, init = init))
