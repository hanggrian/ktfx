@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _VBox(spacing: Double) : VBox(spacing), NodeManager, VGrowedPane, MarginedPane {

    override val collection: MutableCollection<Node> get() = children

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [VBox]. */
fun vbox(
    spacing: Double = 0.0,
    init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = _VBox(spacing).also { init?.invoke(it) }

/** Creates a [VBox] and add it to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    noinline init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = ktfx.layouts.vbox(spacing, init)()