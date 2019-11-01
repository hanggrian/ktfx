@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Ellipse

/** Create an [Ellipse] with initialization block. */
inline fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: (@LayoutDslMarker Ellipse).() -> Unit
): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply(init)

/** Add an [Ellipse] to this manager. */
fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0
): Ellipse = addNode(Ellipse(centerX, centerY, radiusX, radiusY))

/** Add an [Ellipse] with initialization block to this manager. */
inline fun NodeManager.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: (@LayoutDslMarker Ellipse).() -> Unit
): Ellipse = addNode(Ellipse(centerX, centerY, radiusX, radiusY), init)
