@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/**
 * Not extending [NodeManager] because DSL is discouraged.
 * Use `center`, `top`, `right`, `bottom`, and/or `left`.
 */
open class _BorderPane : BorderPane(), AlignedPane, MarginedPane {

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [BorderPane]. */
fun borderPane(
    init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = _BorderPane().also { init?.invoke(it) }

/** Creates a [BorderPane] and add it to this manager. */
inline fun NodeManager.borderPane(
    noinline init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = ktfx.layouts.borderPane(init)()