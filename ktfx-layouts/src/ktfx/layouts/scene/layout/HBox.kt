@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _HBox(spacing: Double, vararg children: Node) : HBox(spacing, *children), NodeManager, HGrowedPane,
    MarginedPane {

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [HBox]. */
fun hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = _HBox(spacing, *children).also { init?.invoke(it) }

/** Creates a [HBox] and add it to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = ktfx.layouts.hbox(spacing, *children, init = init)()