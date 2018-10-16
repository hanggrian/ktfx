@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.QuadCurveTo
import ktfx.PathElementManager
import ktfx.annotations.LayoutDsl

/** Creates a [QuadCurveTo]. */
fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: ((@LayoutDsl QuadCurveTo).() -> Unit)? = null
): QuadCurveTo = QuadCurveTo(controlX, controlY, x, y).also { init?.invoke(it) }

/** Creates a [QuadCurveTo] and add it to this manager. */
inline fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    noinline init: ((@LayoutDsl QuadCurveTo).() -> Unit)? = null
): QuadCurveTo = ktfx.layouts.quadCurveTo(controlX, controlY, x, y, init)()