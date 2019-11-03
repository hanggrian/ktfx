@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane

open class KtfxStackPane : StackPane(), NodeManager, AlignConstraints, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [StackPane] with initialization block. */
inline fun stackPane(
    init: (@LayoutDslMarker KtfxStackPane).() -> Unit
): StackPane = KtfxStackPane().apply(init)

/** Add a [StackPane] to this manager. */
fun NodeManager.stackPane(): StackPane =
    addNode(KtfxStackPane())

/** Add a [StackPane] with initialization block to this manager. */
inline fun NodeManager.stackPane(
    init: (@LayoutDslMarker KtfxStackPane).() -> Unit
): StackPane = addNode(KtfxStackPane(), init)
