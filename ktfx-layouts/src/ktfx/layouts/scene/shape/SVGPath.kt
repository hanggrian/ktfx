@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.SVGPath

inline fun svgPath(): SVGPath = svgPath { }

inline fun svgPath(
    init: (@LayoutDsl SVGPath).() -> Unit
): SVGPath = SVGPath().apply(init)

inline fun LayoutManager<Node>.svgPath(): SVGPath = svgPath { }

inline fun LayoutManager<Node>.svgPath(
    init: (@LayoutDsl SVGPath).() -> Unit
): SVGPath = ktfx.layouts.svgPath(init).add()