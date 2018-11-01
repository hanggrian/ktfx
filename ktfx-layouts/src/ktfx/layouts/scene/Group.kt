@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager

open class _Group : Group(), NodeManager {

    override fun <R : Node> R.invoke(): R = also { children += it }
}

/** Creates a [Group]. */
fun group(
    init: ((@LayoutDsl _Group).() -> Unit)? = null
): Group = _Group().also { init?.invoke(it) }

/** Creates a [Group] and add it to this manager. */
inline fun NodeManager.group(
    noinline init: ((@LayoutDsl _Group).() -> Unit)? = null
): Group = ktfx.layouts.group(init)()