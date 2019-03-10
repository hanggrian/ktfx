@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

open class _VBox(spacing: Double) : VBox(spacing), NodeManager, VGrowableConstraints, MarginableConstraints {

    override fun <R : Node> R.add(): R = also { children += it }

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
    init: ((@LayoutMarker _VBox).() -> Unit)? = null
): VBox = _VBox(spacing).also { init?.invoke(it) }

/** Creates a [VBox] and add it to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    noinline init: ((@LayoutMarker _VBox).() -> Unit)? = null
): VBox = ktfx.layouts.vbox(spacing, init).add()