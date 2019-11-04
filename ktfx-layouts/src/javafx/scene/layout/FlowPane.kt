@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.layout.FlowPane

open class KtfxFlowPane(orientation: Orientation, hgap: Double, vgap: Double) : FlowPane(orientation, hgap, vgap),
    NodeManager, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [FlowPane] with initialization block. */
inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane = KtfxFlowPane(orientation, hgap, vgap).apply(init)

/** Add a [FlowPane] to this manager. */
fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap
): FlowPane = addNode(KtfxFlowPane(orientation, hgap, vgap))

/** Add a [FlowPane] with initialization block to this manager. */
inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane = addNode(KtfxFlowPane(orientation, hgap, vgap), init)
