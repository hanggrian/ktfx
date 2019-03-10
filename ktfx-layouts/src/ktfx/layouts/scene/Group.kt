@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node

open class _Group : Group(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Creates a [Group]. */
fun group(
    init: ((@LayoutMarker _Group).() -> Unit)? = null
): Group = _Group().also { init?.invoke(it) }

/** Creates a [Group] and add it to this manager. */
inline fun NodeManager.group(
    noinline init: ((@LayoutMarker _Group).() -> Unit)? = null
): Group = ktfx.layouts.group(init).add()