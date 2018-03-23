@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.SVGPath

inline fun svgPath(noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }

inline fun Manager<Node>.svgPath(noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null): SVGPath = ktfx.layouts.svgPath(init).add()