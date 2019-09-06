@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

open class _Path : Path(), PathElementManager {

    override fun <T : PathElement> addElement(element: T): T = element.also { elements += it }
}

/** Create a [Path] with initialization block. */
inline fun path(
    init: (@LayoutDslMarker _Path).() -> Unit
): Path = _Path().apply(init)

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path =
    addNode(ktfx.layouts.path { })

/** Add a [Path] with initialization block to this manager. */
inline fun NodeManager.path(
    init: (@LayoutDslMarker _Path).() -> Unit
): Path = addNode(ktfx.layouts.path(init))
