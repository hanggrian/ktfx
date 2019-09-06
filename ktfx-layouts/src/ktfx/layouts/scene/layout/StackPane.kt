@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane

open class _StackPane : StackPane(), NodeManager, AlignConstraints, MarginConstraints {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [StackPane] with initialization block. */
inline fun stackPane(
    init: (@LayoutDslMarker _StackPane).() -> Unit
): StackPane = _StackPane().apply(init)

/** Add a [StackPane] to this manager. */
fun NodeManager.stackPane(): StackPane =
    addNode(ktfx.layouts.stackPane { })

/** Add a [StackPane] with initialization block to this manager. */
inline fun NodeManager.stackPane(
    init: (@LayoutDslMarker _StackPane).() -> Unit
): StackPane = addNode(ktfx.layouts.stackPane(init))
