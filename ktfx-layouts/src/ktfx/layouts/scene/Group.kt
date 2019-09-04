@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node

open class _Group : Group(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Add a [Group] to this manager. */
fun NodeManager.group(): Group =
    Group().add()

/** Add a [Group] with initialization block to this manager. */
inline fun NodeManager.group(
    init: (@LayoutDslMarker _Group).() -> Unit
): Group = (group() as _Group).apply(init)
