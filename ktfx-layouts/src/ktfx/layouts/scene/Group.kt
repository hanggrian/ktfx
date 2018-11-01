@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.LayoutDsl

open class _Group : Group(), NodeManager {

    override val collection: MutableCollection<Node> get() = children
}

/** Creates a [Group]. */
fun group(
    init: ((@LayoutDsl _Group).() -> Unit)? = null
): Group = _Group().also { init?.invoke(it) }

/** Creates a [Group] and add it to this manager. */
inline fun NodeManager.group(
    noinline init: ((@LayoutDsl _Group).() -> Unit)? = null
): Group = ktfx.layouts.group(init)()