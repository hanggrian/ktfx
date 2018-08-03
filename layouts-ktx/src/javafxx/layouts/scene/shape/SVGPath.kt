@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.SVGPath

/** Creates a [SVGPath]. */
fun svgPath(
    init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = SVGPath().also {
    init?.invoke(it)
}

/** Creates a [SVGPath] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.svgPath(
    noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = javafxx.layouts.svgPath(init)()

/** Create a styled [SVGPath]. */
fun styledSvgPath(
    styleClass: String,
    init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = SVGPath().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SVGPath] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSvgPath(
    styleClass: String,
    noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = javafxx.layouts.styledSvgPath(styleClass, init)()