@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import ktfx.NodeManager
import ktfx.LayoutDsl

open class _FlowPane(orientation: Orientation, hgap: Double, vgap: Double) : FlowPane(orientation, hgap, vgap),
    NodeManager, MarginedPane {

    override val collection: MutableCollection<Node> get() = children

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [FlowPane]. */
fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = _FlowPane(orientation, hgap, vgap).also { init?.invoke(it) }

/** Creates a [FlowPane] and add it to this manager. */
inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    noinline init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = ktfx.layouts.flowPane(orientation, hgap, vgap, init)()