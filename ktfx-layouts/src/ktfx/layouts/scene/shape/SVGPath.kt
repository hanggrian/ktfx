@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.SVGPath

inline fun svgPath(
    noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = SVGPath().also { init?.invoke(it) }

inline fun LayoutManager<Node>.svgPath(
    noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = ktfx.layouts.svgPath(init).add()