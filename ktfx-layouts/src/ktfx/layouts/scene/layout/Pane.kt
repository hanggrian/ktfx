@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane : Pane(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane =
    _Pane().add()

/** Add a [Pane] with initialization block to this manager. */
inline fun NodeManager.pane(
    init: (@LayoutDslMarker _Pane).() -> Unit
): Pane = (pane() as _Pane).apply(init)
