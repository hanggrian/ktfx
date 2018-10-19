@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.CubicCurveTo
import ktfx.PathElementManager
import ktfx.annotations.LayoutDsl

/** Creates a [CubicCurveTo]. */
fun cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: ((@LayoutDsl CubicCurveTo).() -> Unit)? = null
): CubicCurveTo = CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y).also { init?.invoke(it) }

/** Creates a [CubicCurveTo] and add it to this manager. */
inline fun PathElementManager.cubicCurveTo(
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    noinline init: ((@LayoutDsl CubicCurveTo).() -> Unit)? = null
): CubicCurveTo = ktfx.layouts.cubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y, init)()