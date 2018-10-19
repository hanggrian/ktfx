@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import ktfx.NodeManager
import ktfx.PathElementManager
import ktfx.annotations.LayoutDsl

open class _Path : Path(), PathElementManager {

    override val collection: MutableCollection<PathElement> = elements
}

/** Creates a [Path]. */
fun path(
    init: ((@LayoutDsl _Path).() -> Unit)? = null
): Path = _Path().also { init?.invoke(it) }

/** Creates a [Path] and add it to this manager. */
inline fun NodeManager.path(
    noinline init: ((@LayoutDsl _Path).() -> Unit)? = null
): Path = ktfx.layouts.path(init)()