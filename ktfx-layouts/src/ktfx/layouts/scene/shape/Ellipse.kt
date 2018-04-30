@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Ellipse

/** Creates a [Ellipse]. */
fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: ((@LayoutDsl Ellipse).() -> Unit)? = null
): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).also {
    init?.invoke(it)
}

/** Creates a [Ellipse] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null
): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()

/** Create a styled [Ellipse]. */
fun styledEllipse(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: ((@LayoutDsl Ellipse).() -> Unit)? = null
): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Ellipse] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledEllipse(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null
): Ellipse = ktfx.layouts.styledEllipse(styleClass, centerX, centerY, radiusX, radiusY, init).add()