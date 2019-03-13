@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

open class _Path : Path(), PathElementManager {

    override fun <R : PathElement> R.add(): R = also { elements += it }
}

/** Creates a [Path]. */
fun path(
    init: ((@LayoutDslMarker _Path).() -> Unit)? = null
): Path = _Path().also { init?.invoke(it) }

/** Creates a [Path] and add it to this manager. */
inline fun NodeManager.path(
    noinline init: ((@LayoutDslMarker _Path).() -> Unit)? = null
): Path = ktfx.layouts.path(init).add()