@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane

open class _StackPane : StackPane(), NodeInvokable, AlignableConstraints, MarginableConstraints {

    override fun <R : Node> R.invoke(): R = also { children += it }

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
    init: ((@LayoutMarker _StackPane).() -> Unit)? = null
): StackPane = _StackPane().also { init?.invoke(it) }

/** Creates a [StackPane] and add it to this manager. */
inline fun NodeInvokable.stackPane(
    noinline init: ((@LayoutMarker _StackPane).() -> Unit)? = null
): StackPane = ktfx.layouts.stackPane(init)()