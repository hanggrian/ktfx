@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Polygon

/** Create a [Polygon] with initialization block. */
inline fun polygon(
    vararg points: Double,
    init: (@LayoutDslMarker Polygon).() -> Unit
): Polygon = Polygon(*points).apply(init)

/** Add a [Polygon] to this manager. */
fun NodeManager.polygon(
    vararg points: Double
): Polygon = addNode(Polygon(*points))

/** Add a [Polygon] with initialization block to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    init: (@LayoutDslMarker Polygon).() -> Unit
): Polygon = addNode(Polygon(*points), init)
