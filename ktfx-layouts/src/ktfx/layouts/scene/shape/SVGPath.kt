@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.SVGPath
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [SVGPath]. */
fun svgPath(
    init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = SVGPath().also { init?.invoke(it) }

/** Creates a [SVGPath] and add it to this manager. */
inline fun NodeManager.svgPath(
    noinline init: ((@LayoutDsl SVGPath).() -> Unit)? = null
): SVGPath = ktfx.layouts.svgPath(init)()