@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.SVGPath

/** Create a [SVGPath] with initialization block. */
inline fun svgPath(
    init: (@LayoutDslMarker SVGPath).() -> Unit
): SVGPath = SVGPath().apply(init)

/** Add a [SVGPath] to this manager. */
fun NodeManager.svgPath(): SVGPath =
    addNode(ktfx.layouts.svgPath { })

/** Add a [SVGPath] with initialization block to this manager. */
inline fun NodeManager.svgPath(
    init: (@LayoutDslMarker SVGPath).() -> Unit
): SVGPath = addNode(ktfx.layouts.svgPath(init))
