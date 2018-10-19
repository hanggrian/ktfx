@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.ArcTo
import ktfx.PathElementManager
import ktfx.annotations.LayoutDsl

/** Creates a [ArcTo]. */
fun arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    init: ((@LayoutDsl ArcTo).() -> Unit)? = null
): ArcTo = ArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag).also { init?.invoke(it) }

/** Creates a [ArcTo] and add it to this manager. */
inline fun PathElementManager.arcTo(
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    xAxisRotation: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    largeArcFlag: Boolean = false,
    sweepFlag: Boolean = false,
    noinline init: ((@LayoutDsl ArcTo).() -> Unit)? = null
): ArcTo = ktfx.layouts.arcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag, init)()