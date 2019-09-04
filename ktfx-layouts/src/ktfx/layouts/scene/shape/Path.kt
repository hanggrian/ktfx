@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

open class _Path : Path(), PathElementManager {

    override fun <R : PathElement> R.add(): R = also { elements += it }
}

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path =
    Path().add()

/** Add a [Path] with initialization block to this manager. */
inline fun NodeManager.path(
    init: (@LayoutDslMarker _Path).() -> Unit
): Path = (path() as _Path).apply(init)
