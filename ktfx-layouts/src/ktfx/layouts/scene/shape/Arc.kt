@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Arc

/** Creates a [Arc]. */
fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).also {
    init?.invoke(it)
}

/** Creates a [Arc] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    noinline init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()

/** Create a styled [Arc]. */
fun styledArc(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Arc] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledArc(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    noinline init: ((@LayoutDsl Arc).() -> Unit)? = null
): Arc = ktfx.layouts.styledArc(styleClass, centerX, centerY, radiusX, radiusY, startAngle, length, init).add()