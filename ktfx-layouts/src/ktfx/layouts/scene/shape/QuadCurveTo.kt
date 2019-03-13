@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.QuadCurveTo

/** Creates a [QuadCurveTo]. */
fun quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    init: ((@LayoutDslMarker QuadCurveTo).() -> Unit)? = null
): QuadCurveTo = QuadCurveTo(controlX, controlY, x, y).also { init?.invoke(it) }

/** Creates a [QuadCurveTo] and add it to this manager. */
inline fun PathElementManager.quadCurveTo(
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    noinline init: ((@LayoutDslMarker QuadCurveTo).() -> Unit)? = null
): QuadCurveTo = ktfx.layouts.quadCurveTo(controlX, controlY, x, y, init).add()