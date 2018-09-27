@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

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
): SVGPath = ktfx.layouts.svgPath(init)()