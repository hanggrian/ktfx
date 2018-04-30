@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

/** Creates a [Circle]. */
fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = Circle(centerX, centerY, radius, fill).also {
    init?.invoke(it)
}

/** Creates a [Circle] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    noinline init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()

/** Create a styled [Circle]. */
fun styledCircle(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = Circle(centerX, centerY, radius, fill).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Circle] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledCircle(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    noinline init: ((@LayoutDsl Circle).() -> Unit)? = null
): Circle = ktfx.layouts.styledCircle(styleClass, centerX, centerY, radius, fill, init).add()