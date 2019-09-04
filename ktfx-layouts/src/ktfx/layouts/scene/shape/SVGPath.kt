@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.SVGPath

/** Add a [SVGPath] to this manager. */
fun NodeManager.svgPath(): SVGPath =
    SVGPath().add()

/** Add a [SVGPath] with initialization block to this manager. */
inline fun NodeManager.svgPath(
    init: (@LayoutDslMarker SVGPath).() -> Unit
): SVGPath = svgPath().apply(init)
