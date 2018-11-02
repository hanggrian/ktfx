@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [Circle]. */
fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = Circle(centerX, centerY, radius, fill).also { init?.invoke(it) }

/** Creates a [Circle] and add it to this manager. */
inline fun NodeInvokable.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    noinline init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init)()