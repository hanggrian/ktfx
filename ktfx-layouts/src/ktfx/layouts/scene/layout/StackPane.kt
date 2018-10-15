@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _StackPane(vararg children: Node) : StackPane(*children), NodeManager, AlignedPane, MarginedPane {

    override val collection: MutableCollection<Node> get() = children

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [StackPane]. */
fun stackPane(
    vararg children: Node,
    init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = _StackPane(*children).also { init?.invoke(it) }

/** Creates a [StackPane] and add it to this manager. */
inline fun NodeManager.stackPane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = ktfx.layouts.stackPane(*children, init = init)()