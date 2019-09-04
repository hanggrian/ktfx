@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Polygon

/** Add a [Polygon] to this manager. */
fun NodeManager.polygon(
    vararg points: Double
): Polygon = Polygon(*points).add()

/** Add a [Polygon] with initialization block to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    init: (@LayoutDslMarker Polygon).() -> Unit
): Polygon = polygon(*points).apply(init)
