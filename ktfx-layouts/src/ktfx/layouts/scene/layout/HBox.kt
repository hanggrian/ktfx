@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.HBox

open class _HBox(spacing: Double) : HBox(spacing), HBoxConstraints {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create an [HBox] with initialization block. */
inline fun hbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker _HBox).() -> Unit
): HBox = _HBox(spacing).apply(init)

/** Add an [HBox] to this manager. */
fun NodeManager.hbox(
    spacing: Double = 0.0
): HBox = addNode(ktfx.layouts.hbox(spacing) { })

/** Add an [HBox] with initialization block to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker _HBox).() -> Unit
): HBox = addNode(ktfx.layouts.hbox(spacing, init))
