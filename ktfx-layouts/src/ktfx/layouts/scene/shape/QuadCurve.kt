@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.QuadCurve

/** Creates a [QuadCurve]. */
fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutMarker QuadCurve).() -> Unit)? = null
): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).also { init?.invoke(it) }

/** Creates a [QuadCurve] and add it to this manager. */
inline fun NodeInvokable.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutMarker QuadCurve).() -> Unit)? = null
): QuadCurve = ktfx.layouts.quadCurve(startX, startY, controlX, controlY, endX, endY, init)()