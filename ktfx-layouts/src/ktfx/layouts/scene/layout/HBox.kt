@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.HBox

open class _HBox(spacing: Double) : HBox(spacing), HBoxConstraints {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Add an [HBox] to this manager. */
fun NodeManager.hbox(
    spacing: Double = 0.0
): HBox = _HBox(spacing).add()

/** Add an [HBox] with initialization block to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker _HBox).() -> Unit
): HBox = (hbox(spacing) as _HBox).apply(init)
