@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

open class _BorderPane(
    center: Node?,
    top: Node?,
    right: Node?,
    bottom: Node?,
    left: Node?
) : BorderPane(center, top, right, bottom, left), LayoutManager<Node>, AlignedPane,
    MarginedPane {

    override fun <R : Node> R.invoke(): R = error("Don't invoke in BorderPane, specify its side manually")

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
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = _BorderPane(center, top, right, bottom, left).also { init?.invoke(it) }

/** Creates a [BorderPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.borderPane(
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    noinline init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = ktfx.layouts.borderPane(center, top, right, bottom, left, init)()